package lotto;

public class InputValidation {

    static final String MONEY_NOT_LONG = "[ERROR] 구입금액이 정수가 아닙니다.";
    static final String MONEY_NOT_MULTIPLE_OF_ONE_THOUSAND = "[ERROR] 구입금액이 1,000원으로 나누어 떨어지는 자연수가 아닙니다.";

    static long money;
    static Input input = new Input();

    public static long validatedMoney(String inputMoney) {
        while (true) {
            try {
                parseLongOrThrow(inputMoney);
                multipleOfOneThousandOrThrow(money);
                return money;
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException 발생");// 테스트출력
                inputMoney = input.enterMoney();
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException 발생"); //테스트출력
                inputMoney = input.enterMoney();
            }
        }
    }

    private static void parseLongOrThrow(String inputMoney) {
        try {
            money = Long.parseLong(inputMoney);
            System.out.println("입력받은 금액은 정수입니다."); // 테스트 출력
        } catch (NumberFormatException e) {
            System.out.println(MONEY_NOT_LONG);
            throw new NumberFormatException();
        }
    }

    private static void multipleOfOneThousandOrThrow(long money) {
        if (money <= 0 || money % 1000 != 0) {
            System.out.println(MONEY_NOT_MULTIPLE_OF_ONE_THOUSAND);
            throw new IllegalArgumentException(MONEY_NOT_MULTIPLE_OF_ONE_THOUSAND);
        }
        System.out.println("입력받은 금액은 1,000의 배수 입니다.."); // 테스트 출력
    }
}
