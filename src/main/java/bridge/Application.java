package bridge;

import bridge.controller.BridgeGameController;

public class Application {
    private final static BridgeGameController bridgeGameController = new BridgeGameController();

    public static void main(String[] args) {
        bridgeGameController.run();
    }
}
