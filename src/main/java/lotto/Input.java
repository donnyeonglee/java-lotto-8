package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public String enterMoney() {
        System.out.println(PROMPT_MONEY);
        return Console.readLine();
    }

    public String enterWinnningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        return Console.readLine();
    }
}
