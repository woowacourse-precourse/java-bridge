package bridge.controller;

import bridge.service.BridgeService;

public class BridgeController {
    private BridgeService bridgeService;

    public BridgeController() {
        this.bridgeService = new BridgeService();
    }

    public void startProgram() {
        startGame();
    }

    public void startGame() {
        bridgeService.initGame();
        bridgeService.bridgeMake();
        do {
            playGame();
            if (bridgeService.isSuccess()) {
                break;
            }
        } while (bridgeService.isRetry());
        exitGame();
    }

    public void playGame() {
        do {
            bridgeService.moveBridge();
            bridgeService.presentMap();
        } while (bridgeService.isKeepGoing());
    }

    public void exitGame() {
        bridgeService.exitGame();
    }

}
