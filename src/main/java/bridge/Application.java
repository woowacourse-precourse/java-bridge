package bridge;

import bridge.controller.AbstractGameController;
import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        AbstractGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.run();
    }
}
