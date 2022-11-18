package bridge;

import bridge.domain.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.run();
    }
}
