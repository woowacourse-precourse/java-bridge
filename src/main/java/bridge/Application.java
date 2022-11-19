package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.start();
    }
}
