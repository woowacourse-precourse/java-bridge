package bridge;

import bridge.controller.BridgeController;
import bridge.domain.generator.BridgeRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new BridgeRandomNumberGenerator());
        bridgeController.runGame();
    }
}
