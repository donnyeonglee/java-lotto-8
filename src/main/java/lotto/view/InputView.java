package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    static final String PROMPT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String enterMoney() {
        System.out.println(PROMPT_MONEY);
        return Console.readLine();
    }

    public String enterLottoNumbers() {
        System.out.println(PROMPT_LOTTO_NUMBERS);
        return Console.readLine();
    }

    public String enterBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        return Console.readLine();
    }
}
