package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeGameController {
    public void run() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();

        InputView inputView = new InputView();
        String bridgeSize = inputView.readBridgeSize();
    }
}
