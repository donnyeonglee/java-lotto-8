package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(2001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}