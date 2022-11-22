package bridge;

import bridge.controller.BridgeController;

public class BridgeGameRunner {

    private final BridgeController bridgeController;

    public BridgeGameRunner(BridgeController bridgeController) {
        this.bridgeController = bridgeController;
    }

    public void run() {
        try {
            bridgeController.startGame();
            do {
                bridgeController.onGame();
            } while (bridgeController.isNotEnd());
            bridgeController.endGame();
        } catch (RuntimeException exception) {
            bridgeController.handleException(exception);
        }
    }
}
