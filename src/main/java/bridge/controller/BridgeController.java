package bridge.controller;

import bridge.model.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService = new BridgeService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        createBridge();
    }

    private void createBridge() {
        int bridgeSize = inputView.readBridgeSize();

    }

}
