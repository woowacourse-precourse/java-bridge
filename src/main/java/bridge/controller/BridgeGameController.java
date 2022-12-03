package bridge.controller;

import bridge.service.BridgeGameService;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
    }

    public void start(){

        bridgeGameService.startBridgeGame();
        bridgeGameService.playLoop();
        bridgeGameService.printResult();

    }
}
