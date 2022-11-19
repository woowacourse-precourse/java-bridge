package bridge.controller;

import bridge.dto.BridgeCrossingDTO;
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
        moveBridge();
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

    private void moveBridge() {
        String bridgeMoving;

        try {
            OutputView.printInputMoving();
            bridgeMoving = InputView.inputBridgeMove();

            BridgeCrossingDTO bridgeCrossingDTO = bridgeService.moveUser(bridgeMoving);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            moveBridge();
        }
    }

}
