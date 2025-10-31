package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TicketGenerator {

    private final long money;
    int purchaseCount;
    List<List<Integer>> tickets = new ArrayList<>();

    public TicketGenerator(long money) {
        this.money = money;
        this.purchaseCount = (int)(money / 1000);
        System.out.println(purchaseCount + "개를 구매했습니다.");
        generateTickets(purchaseCount);
        this.tickets = tickets;
    }

    public void generateTickets(int purchaseCount) {
        for (int num = 0; num < purchaseCount; num++) {
            tickets.add(generateSingleTicket());
        }
    }

    public List<Integer> generateSingleTicket() {
        List<Integer> ticket = new ArrayList<>();
        ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ticket.sort(Comparator.naturalOrder());
        System.out.println(ticket);
        return ticket;
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
