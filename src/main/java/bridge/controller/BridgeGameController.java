package bridge.controller;

import bridge.constant.enumtype.UIMessage;
import bridge.service.BridgeGameInputService;

public class BridgeGameController {
    private BridgeGameInputService bridgeGameInputService;

    private BridgeGameController() {
        bridgeGameInputService = new BridgeGameInputService();
    }

    private static class InnerBridgeGameController {
        private static final BridgeGameController instance = new BridgeGameController();
    }

    public static BridgeGameController getInstance() {
        return InnerBridgeGameController.instance;
    }

    public void bridgeGameStart() {
        System.out.println(UIMessage.INFO_GAME_START.getValue());
        bridgeGameInputService.readBridgeSize();
    }
}
