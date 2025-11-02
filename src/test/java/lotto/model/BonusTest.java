package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Bonus(6, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

}