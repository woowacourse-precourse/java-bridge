package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInit();
        int size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
    }
}
