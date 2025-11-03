package lotto.model;

import java.util.List;

public class Bonus {
    private final int number; // 보너스 번호
    private final List<Integer> lottoNumbers; // 당첨 번호

    public Bonus(int number, List<Integer> lottoNumbers) {
        validate(number, lottoNumbers);
        this.number = number;
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(int number, List<Integer> lottoNumbers) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45여야 합니다.");
        }
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 없는 번호여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
