package lotto;

import lotto.model.CheckResults;
import lotto.view.Input;
import lotto.view.InputValidator;
import lotto.model.TicketGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();


        long money = InputValidator.validatedMoney(input.enterMoney());
        System.out.println("구매금액 : " + money); // 테스트 출력. long 자료형

        TicketGenerator ticketGenerator = new TicketGenerator(money);
        System.out.println(ticketGenerator.getTickets()); // 테스트 출력

        List<Integer> lottoNumbers = InputValidator.validatedLottoNumbers(input.enterLottoNumbers());
        System.out.println("당첨번호 : " + lottoNumbers); // 테스트 출력. List<Integer>

        int bonusNumber = InputValidator.validatedBonusNumber(input.enterBonusNumber());
        System.out.println("보너스번호 : " + bonusNumber); // 테스트 출력

        CheckResults checkResults = new CheckResults(lottoNumbers, bonusNumber, ticketGenerator.getTickets());
        System.out.println("등수 별 카운트 : " + checkResults.getEachRankCount()); // 테스트 출력
        System.out.println("총 당첨 금액 : " + checkResults.getTotalPrize()); // 테스트 출력
        System.out.println("수익률 : " + 100 * checkResults.getTotalPrize() / money + "%"); // 테스트 출력
    }
}
