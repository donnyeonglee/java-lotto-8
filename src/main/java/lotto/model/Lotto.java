package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45여야 합니다.");
        }
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
