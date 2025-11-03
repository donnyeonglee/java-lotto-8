package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckResultsTest {
    @DisplayName("구입금액 1000원 2등 당첨 기능 테스트")
    @Test
    void 구입금액1000원_2등_당첨_기능_테스트() {
        long money = 1000;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<List<Integer>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등 당첨
        CheckResults checkResults = new CheckResults(money, lottoNumbers, bonusNumber, tickets);
        assertThat(String.format("%,.1f%%", checkResults.getYield())).isEqualTo("3,000,000.0%");
        assertThat(checkResults.getEachRankCount()).isEqualTo(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0)));
    }

    @DisplayName("구입금액 5000원 모든 등수 당첨 기능 테스트")
    @Test
    void 구입금액6000원_모든_등수_당첨_기능_테스트() {
        long money = 6000;
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<List<Integer>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8))); // 3등
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8))); // 4등
        tickets.add(new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10))); // 5등
        tickets.add(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16))); // 낙첨
        CheckResults checkResults = new CheckResults(money, lottoNumbers, bonusNumber, tickets);
        assertThat(String.format("%,.1f%%", checkResults.getYield())).isEqualTo("33,859,250.0%");
        assertThat(checkResults.getEachRankCount()).isEqualTo(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
    }
}