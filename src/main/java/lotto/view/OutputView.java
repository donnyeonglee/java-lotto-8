package lotto.view;

import java.util.List;
import lotto.model.Rank;

public class OutputView {
    public void printTicketList(String ticketList) {
        System.out.println(ticketList);
    }

    public void printResultStat(double yield, List<Integer> eachRankCount) {
        String resultStat = "\n당첨 통계\n---\n";
        Rank[] ranks = Rank.values();
        for (int num = ranks.length - 1; num >= 0; num -= 1) {
            resultStat = resultStat.concat(ranks[num].getRankDescription() + " - " + eachRankCount.get(num) + "개\n");
        }
        resultStat = resultStat.concat(String.format("총 수익률은 %,.1f%%입니다.", yield));
        System.out.println(resultStat);
    }
}
