package lotto.view;

public class Money {
    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어지는 자연수여야 합니다.");
        }
    }

    public long getMoney() {
        return money;
    }
}
