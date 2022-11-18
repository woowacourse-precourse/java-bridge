package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();

    public void run() {
        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
    }
}
