package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;

public class InputValidator {
    static InputView inputView = new InputView();
    static List<Integer> lottoNumbers;

    public static long validatedMoney(String inputMoney) {
        while (true) {
            try {
                Money money = new Money(parseLongOrThrow(inputMoney));
                return money.getMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputMoney = inputView.enterMoney();
            }
        }
    }

    public static List<Integer> validatedLottoNumbers(String inputLottoNumbers) {
        while (true) {
            try {
                Lotto lotto = new Lotto(convertStringArrToIntArr(splitLottoNumbers(inputLottoNumbers)));
                lottoNumbers = lotto.getNumbers();
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputLottoNumbers = inputView.enterLottoNumbers();
            }
        }
    }

    public static int validatedBonusNumber(String inputBonusNumber) {
        while (true) {
            try {
                int bonusNumber = parseIntOrThrow(inputBonusNumber);
                Bonus bonus = new Bonus(bonusNumber, lottoNumbers);
                return bonus.getNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputBonusNumber = inputView.enterBonusNumber();
            }
        }

    }

    private static long parseLongOrThrow(String inputMoney) {
        try {
            return Long.parseLong(inputMoney.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 정수가 아닙니다.");
        }
    }

    private static List<String> splitLottoNumbers(String inputLottoNumbers) {
        String separator = ",";
        List<String> inputLottoNumbersList = new ArrayList<>();
        inputLottoNumbersList = Arrays.asList(inputLottoNumbers.split(separator));
        return inputLottoNumbersList;
    }

    private static List<Integer> convertStringArrToIntArr(List<String> inputWinningNumbersList) {
        List<Integer> lottoNumbers = new ArrayList<>();
        int validatedNum;
        for (String num : inputWinningNumbersList) {
            throwWhenBlank(num);
            validatedNum = parseIntOrThrow(num);
            lottoNumbers.add(validatedNum);
        }
        return lottoNumbers;
    }

    private static void throwWhenBlank(String inputNumber) {
        if (inputNumber.isBlank()) {
            System.out.println("[ERROR] 당첨 번호에 빈 값이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static int parseIntOrThrow(String inputNumber) {
        int number;
        try {
            number = Integer.parseInt(inputNumber.trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 번호는 정수여야 합니다.");
            throw new IllegalArgumentException();
        }
        return number;
    }
}
