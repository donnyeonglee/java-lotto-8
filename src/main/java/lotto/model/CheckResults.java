package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckResults {

    private final List<Integer> lottoNumbers;
    private final int bonusNumber;
    private final List<List<Integer>> tickets;
    private List<Integer> eachRankCount;
    private long totalPrize;
    private double yield;

    public CheckResults(long money, List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> tickets) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        this.tickets = tickets;
        this.eachRankCount = countEachRank(lottoNumbers, bonusNumber, tickets);
        this.totalPrize = calculateTotalPrize(eachRankCount);
        this.yield = (100.0 * totalPrize) / money;
    }

    private List<Integer> countEachRank(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> tickets) {
        List<Integer> assignedRankList = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            int lottoNumbersMatchCount = CountLottoNumbersMatch(lottoNumbers, ticket);
            int bonusNumberMatchCount = CountBonusNumberMatch(bonusNumber, ticket);
            if (lottoNumbersMatchCount != 5) {
                bonusNumberMatchCount = -1;
            }
            List<Integer> matchCountPair = new ArrayList<>();
            matchCountPair.add(lottoNumbersMatchCount);
            matchCountPair.add(bonusNumberMatchCount);
            assignedRankList.add(findRankByMatchCount(matchCountPair));
        }
        return countEachValueInList(assignedRankList);
    }

    private int CountLottoNumbersMatch(List<Integer> lottoNumbers, List<Integer> ticket) {
        int matchCount = 0;
        for (int num : ticket) {
            if (lottoNumbers.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int CountBonusNumberMatch(int bonusNumber, List<Integer> ticket) {
        int matchCount = 0;
        if (ticket.contains(bonusNumber)) {
            matchCount = 1;
        }
        return matchCount;
    }

    private int findRankByMatchCount(List<Integer> matchCountPair) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (matchCountPair.equals(rank.getMatchCountPair())) {
                return rank.getRank();
            }
        }
        return -1;
    }

    private List<Integer> countEachValueInList(List<Integer> assignedRankList) {
        int firstRankCount = Collections.frequency(assignedRankList, 1);
        int secondRankCount = Collections.frequency(assignedRankList, 2);
        int thirdRankCount = Collections.frequency(assignedRankList, 3);
        int fourthRankCount = Collections.frequency(assignedRankList, 4);
        int fifthRankCount = Collections.frequency(assignedRankList, 5);
        return new ArrayList<>(Arrays.asList(firstRankCount, secondRankCount, thirdRankCount, fourthRankCount, fifthRankCount));
    }

    private long calculateTotalPrize(List<Integer> eachRankCount) {
        Rank[] ranks = Rank.values();
        long totalPrize = 0;
        for (Rank rank : ranks) {
            int count = eachRankCount.get(rank.getRank() - 1);
            int prize = rank.getPrize();
            long rankTotalPrize = (long) count * prize;
            totalPrize += rankTotalPrize;
        }
        return totalPrize;
    }

    public List<Integer> getEachRankCount() {
        return eachRankCount;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double getYield() {
        return yield;
    }
}
