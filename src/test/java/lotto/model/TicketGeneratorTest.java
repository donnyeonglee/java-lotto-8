package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketGeneratorTest {
    @DisplayName("구입금액이 3000원이면 복권 3개를 구매한다.")
    @Test
    void 구입금액이_3000원이면_복권_3개를_구매한다() {
        TicketGenerator ticketGenerator = new TicketGenerator(3000);
        assertThat(ticketGenerator.ticketList).contains("3개를 구매했습니다.");
        assertThat(ticketGenerator.getTickets().size() == 3).isTrue();
    }
}