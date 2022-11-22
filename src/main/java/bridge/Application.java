package bridge;

import bridge.controller.BridgeGameController;

public class Application {
    private static final BridgeGameController bridgeGameController = new BridgeGameController();

    public static void main(String[] args) {
        bridgeGameController.generateBridgeGame();
        bridgeGameController.run();
    }
}
