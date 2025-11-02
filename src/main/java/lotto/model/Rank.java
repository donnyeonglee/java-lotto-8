package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST_RANK(Arrays.asList(6, -1), 1, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_RANK(Arrays.asList(5, 1), 2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_RANK(Arrays.asList(5, 0), 3, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH_RANK(Arrays.asList(4, -1), 4, 50000, "4개 일치 (50,000원)"),
    FIFTH_RANK(Arrays.asList(3, -1), 5, 5000, "3개 일치 (5,000원)");

    private final List<Integer> matchCountPair;
    private final int rank;
    private final int prize;
    private final String rankDescription;

    Rank(List<Integer> matchCountPair, int rank, int prize, String rankDescription) {
        this.matchCountPair = matchCountPair;
        this.rank = rank;
        this.prize = prize;
        this.rankDescription = rankDescription;
    }

    public List<Integer> getMatchCountPair() {
        return matchCountPair;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getRankDescription() {
        return rankDescription;
    }
}
