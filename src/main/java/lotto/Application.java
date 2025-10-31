package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();

        long money = InputValidator.validatedMoney(input.enterMoney());
        System.out.println("구매금액 : " + money); // 테스트 출력

        InputValidator.validatedWinningNumbers(input.enterWinnningNumbers());

        InputValidator.validateBonusNumber(input.enterBonusNumber());
    }
}
