package bridge;

import bridge.controller.BridgeController;
import bridge.controller.BridgeGameController;

public class Application {
    private static final BridgeGameController bridgeGameController = new BridgeGameController();
    private static final BridgeController bridgeController = new BridgeController();

    public static void main(String[] args) {
        init();
        bridgeGameController.run();
    }

    private static void init() {
        bridgeGameController.generateBridgeGame();
        bridgeController.generateBridge();
    }
}
