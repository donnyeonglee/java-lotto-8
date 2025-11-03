package lotto.controller;

import java.util.List;

import lotto.model.CheckResults;
import lotto.model.TicketGenerator;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        long money = InputValidator.validatedMoney(inputView.enterMoney()); // 구입금액 입력

        TicketGenerator ticketGenerator = new TicketGenerator(money); // 구매 및 결과 출력
        outputView.printTicketList(ticketGenerator.getTicketList());

        List<Integer> lottoNumbers = InputValidator.validatedLottoNumbers(inputView.enterLottoNumbers()); // 당첨 번호 입력
        int bonusNumber = InputValidator.validatedBonusNumber(inputView.enterBonusNumber()); // 보너스 번호 입력

        // 당첨 확인 및 출력
        CheckResults checkResults = new CheckResults(money, lottoNumbers, bonusNumber, ticketGenerator.getTickets());
        outputView.printResultStat(checkResults.getYield(), checkResults.getEachRankCount());
    }
}
