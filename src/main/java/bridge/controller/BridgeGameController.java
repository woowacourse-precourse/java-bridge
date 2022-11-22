package bridge.controller;

import bridge.service.BridgeService;
import bridge.vo.ErrorMessage;

public class BridgeGameController {
    BridgeService bridgeService = new BridgeService();

    public void run() {
        try {
            bridgeService.startBridgeGame();
            bridgeService.moveBridge();
            System.out.println();
            bridgeService.endBridgeGame();
        } catch (IllegalStateException e) {
            System.out.println(ErrorMessage.STATE_EXCEPTION.getErrorMessage());
        }
    }
}
