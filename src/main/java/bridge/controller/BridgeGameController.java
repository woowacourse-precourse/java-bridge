package bridge.controller;

import bridge.constant.enumtype.UIMessage;
import bridge.service.BridgeGameService;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;

    private BridgeGameController() {
        bridgeGameService = new BridgeGameService();
    }

    private static class InnerBridgeGameController {
        private static final BridgeGameController instance = new BridgeGameController();
    }

    public static BridgeGameController getInstance() {
        return InnerBridgeGameController.instance;
    }

    public void bridgeGameStart() {
        System.out.println(UIMessage.INFO_GAME_START.getValue());
        bridgeGameService.createBridge();
        Boolean isPassedMoving = bridgeGameService.moveBridge();
        if (!isPassedMoving) {
            bridgeGameService.bridgeGameRetry();
        }
        bridgeGameService.printResult();
    }
}
