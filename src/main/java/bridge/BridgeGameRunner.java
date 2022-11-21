package bridge;

import bridge.controller.BridgeController;

public class BridgeGameRunner {

    private final BridgeController bridgeController;

    public BridgeGameRunner(BridgeController bridgeController) {
        this.bridgeController = bridgeController;
    }

    public void run() {
        bridgeController.startGame();
        do {
            bridgeController.onGame();
        } while (bridgeController.isNotFailure());
        bridgeController.endGame();
    }
}
