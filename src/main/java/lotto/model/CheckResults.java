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

    public CheckResults(List<Integer> lottoNumbers, int bonusNumber, List<List<Integer>> tickets) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        this.tickets = tickets;
        this.eachRankCount = countEachRank(lottoNumbers, bonusNumber, tickets);
        this.totalPrize = calculateTotalPrize(eachRankCount);
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
            //System.out.println("일치하는 당첨 번호 수 : " + CountLottoNumbersMatch(lottoNumbers, ticket)); // 테스트 출력
            //System.out.println("일치하는 보너스 번호 수 : " + CountBonusNumberMatch(bonusNumber, ticket)); // 테스트 출력
            //System.out.println("일치하는 번호 수 쌍 : " + matchCountPair); // 테스트 출력
            assignedRankList.add(findRankByMatchCount(matchCountPair));
        }
        System.out.println("각 티켓의 등수 : " + assignedRankList); // 테스트 출력
        System.out.println("각 등수별 카운트 : " + countEachValueInList(assignedRankList)); // 테스트 출력
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
                int rankNum = rank.getRank();// 테스트
                System.out.println("당첨" + rank.getMatchCountPair() + " 등수 : " + rankNum);// 테스트 출력
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
}
