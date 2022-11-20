package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class ResultController {
    private final InputView inputView;
    private final OutputView outputView;

    public ResultController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

}
