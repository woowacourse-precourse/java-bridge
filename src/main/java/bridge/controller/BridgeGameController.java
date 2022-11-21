package bridge.controller;

import bridge.service.BridgeService;

public class BridgeGameController {
    BridgeService bridgeService = new BridgeService();

    public void run(){
        bridgeService.startBridgeGame();
        bridgeService.moveBridge();
    }
}
