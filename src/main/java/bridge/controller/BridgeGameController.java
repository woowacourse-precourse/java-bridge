package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BridgeGameController() {
    }

    public void run() {
        outputView.printGameStart();
    }
}
