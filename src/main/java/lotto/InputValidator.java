package lotto;

import java.util.*;

public class InputValidator {

    static final String MONEY_NOT_LONG = "[ERROR] 구입금액이 정수가 아닙니다.";
    static final String MONEY_NOT_MULTIPLE_OF_ONE_THOUSAND = "[ERROR] 구입금액이 1,000원으로 나누어 떨어지는 자연수가 아닙니다.";
    static final String WINNING_NUMBERS_BLANK = "[ERROR] 당첨 번호에 빈 값이 존재합니다.";
    static final String NUMBER_NOT_INTEGER = "[ERROR] 번호가 정수가 아닙니다.";
    static final String WINNING_NUMBERS_NOT_SIX = "[ERROR] 당첨 번호가 6개가 아닙니다.";
    static final String NUMBER_OUT_OF_RANGE = "[ERROR] 번호가 1~45 숫자 범위를 벗어납니다.";
    static final String WINNING_NUMBERS_CONTAIN_DUPLICATES = "[ERROR] 당첨 번호가 중복을 포함합니다.";
    static final String BONUS_NUMBER_IS_INCLUDED_IN_WINNING_NUMBERS = "[ERROR] 보너스 번호가 당첨 번호에 포함됩니다.";
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;

    static Input input = new Input();
    static long money;
    static List<Integer> winningNumbers = new ArrayList<>();
    static int bonusNumber;

    public static long validatedMoney(String inputMoney) {
        while (true) {
            try {
                parseLongOrThrow(inputMoney);
                multipleOfOneThousandOrThrow(money);
                return money;
            } catch (IllegalArgumentException e) {
                inputMoney = input.enterMoney();
            }
        }
    }

    public static void validatedWinningNumbers(String inputWinningNumbers) {
        System.out.println("inputWinningNumbers : " + separateWinningNumbers(inputWinningNumbers)); // 테스트 출력
        while (true) {
            try {
                convertStringArrToIntArr(separateWinningNumbers(inputWinningNumbers));
                validateSixInputNumbers(winningNumbers);
                validateWinningNumbersRange(winningNumbers);
                validateDuplicate(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                inputWinningNumbers = input.enterWinnningNumbers();
            }
        }
    }

    public static void validateBonusNumber(String inputBonusNumber) {
        while (true) {
            try {
                bonusNumber = parseIntOrThrow(inputBonusNumber);
                validateNumberRange(bonusNumber);
                validateBonusNumberNotInWinningNumbers();
                System.out.println("보너스 번호 : " + bonusNumber); // 테스트 출력
                break;
            } catch (IllegalArgumentException e) {
                inputBonusNumber = input.enterBonusNumber();
            }
        }
    }

    private static void parseLongOrThrow(String inputMoney) {
        try {
            money = Long.parseLong(inputMoney);
            System.out.println("입력받은 금액은 정수입니다."); // 테스트 출력
        } catch (NumberFormatException e) {
            System.out.println(MONEY_NOT_LONG);
            throw new IllegalArgumentException();
        }
    }

    private static void multipleOfOneThousandOrThrow(long money) {
        if (money <= 0 || money % 1000 != 0) {
            System.out.println(MONEY_NOT_MULTIPLE_OF_ONE_THOUSAND);
            throw new IllegalArgumentException();
        }
        System.out.println("입력받은 금액은 1,000의 배수 입니다.."); // 테스트 출력
    }

    private static List<String> separateWinningNumbers(String inputWinningNumbers) {
        String separator = ",";
        List<String> inputWinningNumbersList = new ArrayList<>();
        inputWinningNumbersList = Arrays.asList(inputWinningNumbers.split(separator));
        return inputWinningNumbersList;
    }

    private static void convertStringArrToIntArr(List<String> inputWinningNumbersList) {
        int intValidatedNumber;
        winningNumbers.clear();
        for (String inputNumber : inputWinningNumbersList) {
            System.out.println(inputNumber); // 테스트 출력
            throwWhenBlank(inputNumber);
            intValidatedNumber = parseIntOrThrow(inputNumber);
            winningNumbers.add(intValidatedNumber);
        }
    }

    private static void throwWhenBlank(String inputNumber) {
        if (inputNumber.isBlank()) {
            System.out.println(WINNING_NUMBERS_BLANK);
            throw new IllegalArgumentException();
        }
    }

    private static int parseIntOrThrow(String inputNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_NOT_INTEGER);
            throw new IllegalArgumentException();
        }
        return number;
    }

    private static void validateSixInputNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            System.out.println(WINNING_NUMBERS_NOT_SIX);
            throw new IllegalArgumentException();
        }
    }

    private static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (int num : winningNumbers) {
            System.out.println(num); // 테스트 출력
            validateNumberRange(num);
        }
    }

    private static void validateNumberRange(int num) {
        if (num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) {
            System.out.println(NUMBER_OUT_OF_RANGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (winningNumbersSet.size() != winningNumbers.size()) {
            System.out.println(WINNING_NUMBERS_CONTAIN_DUPLICATES);
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusNumberNotInWinningNumbers() {
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(BONUS_NUMBER_IS_INCLUDED_IN_WINNING_NUMBERS);
            throw new IllegalArgumentException();
        }
    }
}
