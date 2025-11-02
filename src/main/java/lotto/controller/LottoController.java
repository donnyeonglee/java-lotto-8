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
        long money = InputValidator.validatedMoney(inputView.enterMoney());

        TicketGenerator ticketGenerator = new TicketGenerator(money);
        outputView.printTicketList(ticketGenerator.getTicketList());

        List<Integer> lottoNumbers = InputValidator.validatedLottoNumbers(inputView.enterLottoNumbers());

        int bonusNumber = InputValidator.validatedBonusNumber(inputView.enterBonusNumber());

        CheckResults checkResults = new CheckResults(money, lottoNumbers, bonusNumber, ticketGenerator.getTickets());
        outputView.printResultStat(checkResults.getYield(), checkResults.getEachRankCount());
    }
}
