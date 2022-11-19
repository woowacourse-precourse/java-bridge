package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    public void start() {
        OutputView.printStartBridgeGame();
        int bridgeSize = InputView.readBridgeSize();
    }
}
