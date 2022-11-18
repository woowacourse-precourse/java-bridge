package bridge.controller;

import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        OutputView.printGameStart();
        createBridge();
    }

    private void createBridge() {
        int bridgeSize;

        try {
            OutputView.printInputNumber();
            bridgeSize = InputView.inputBridgeSize();
            bridgeService.createBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            createBridge();
        }
    }

}
