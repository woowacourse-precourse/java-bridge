package bridge.controller;

import bridge.service.BridgeGameService;

import java.util.List;

public class BridgeGameController {

    private final BridgeGameService bridgeGameService;

    public BridgeGameController() {
        this.bridgeGameService = new BridgeGameService();
    }

    public void play() {
        List<String> randomBridge = bridgeGameService.getBridge();
        bridgeGameService.gameStart(randomBridge);
    }
}


