package lotto.view;

import java.util.*;

public class InputValidator {

    static final String WINNING_NUMBERS_BLANK = "[ERROR] 당첨 번호에 빈 값이 존재합니다.";
    static final String NUMBER_NOT_INTEGER = "[ERROR] 번호가 정수가 아닙니다.";
    static final String NUMBER_OUT_OF_RANGE = "[ERROR] 번호가 1~45 숫자 범위를 벗어납니다.";
    static final String BONUS_NUMBER_IS_INCLUDED_IN_WINNING_NUMBERS = "[ERROR] 보너스 번호가 당첨 번호에 포함됩니다.";
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;

    static Input input = new Input();
    static List<Integer> lottoNumbers;

    public static long validatedMoney(String inputMoney) {
        while (true) {
            try {
                Money money = new Money(parseLongOrThrow(inputMoney));
                return money.getMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputMoney = input.enterMoney();
            }
        }
    }

    public static List<Integer> validatedLottoNumbers(String inputLottoNumbers) {
        System.out.println("입력한 당첨 번호 : " + splitLottoNumbers(inputLottoNumbers)); // 테스트 출력
        while (true) {
            try {
                Lotto lotto = new Lotto(convertStringArrToIntArr(splitLottoNumbers(inputLottoNumbers)));
                lottoNumbers = lotto.getNumbers();
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputLottoNumbers = input.enterLottoNumbers();
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
                inputBonusNumber = input.enterBonusNumber();
            }
        }

    }

    private static long parseLongOrThrow(String inputMoney) {
        try {
            return Long.parseLong(inputMoney);
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
            System.out.println(WINNING_NUMBERS_BLANK);
            throw new IllegalArgumentException();
        }
    }

    private static int parseIntOrThrow(String inputNumber) {
        int number;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_NOT_INTEGER);
            throw new IllegalArgumentException();
        }
        return number;
    }
}
