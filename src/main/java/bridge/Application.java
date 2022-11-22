package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        final BridgeController bridgeController = new BridgeController();

        bridgeController.executeBridgeGame();
        bridgeController.finishBridgeGame();
    }
}
