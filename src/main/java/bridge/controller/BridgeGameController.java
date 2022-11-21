package bridge.controller;

import bridge.model.Bridge;
import bridge.service.BridgeGameService;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService;

    public BridgeGameController() {
        this.bridgeGameService = new BridgeGameService();
    }

    public void play() {
        Bridge ramdomBridge = bridgeGameService.getRandomBridge();
        bridgeGameService.gameStart(ramdomBridge);
    }
}
