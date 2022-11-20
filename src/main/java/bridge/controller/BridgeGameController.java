package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    public void start(){
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();
    }
}
