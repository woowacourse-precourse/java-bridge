package bridge.controller;

import bridge.service.BridgeService;
import bridge.view.InputView;

public class BridgeController {
    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        createBridge();
    }

    private void createBridge() {
        int bridgeSize;
        try {
            bridgeSize = InputView.inputBridgeSize();
            bridgeService.createBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBridge();
        }
    }

}
