package lotto;

import lotto.view.Input;
import lotto.view.InputValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();

        long money = InputValidator.validatedMoney(input.enterMoney());
        System.out.println("구매금액 : " + money); // 테스트 출력. long 자료형

        List<Integer> lottoNumbers = InputValidator.validatedLottoNumbers(input.enterLottoNumbers());
        System.out.println("당첨번호 : " + lottoNumbers); // 테스트 출력. List<Integer>

        int bonusNumber = InputValidator.validatedBonusNumber(input.enterBonusNumber());
        System.out.println("보너스번호 : " + bonusNumber); // 테스트 출력
    }
}
