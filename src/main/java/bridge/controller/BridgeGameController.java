package bridge.controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        outputView.printIntroMessage();

        int bridgeSize = inputView.readBridgeSize();
    }
}
