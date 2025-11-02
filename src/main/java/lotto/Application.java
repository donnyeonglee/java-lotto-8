package lotto;

import lotto.controller.LottoController;
import lotto.model.CheckResults;
import lotto.view.InputView;
import lotto.view.InputValidator;
import lotto.model.TicketGenerator;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.run();
    }
}
