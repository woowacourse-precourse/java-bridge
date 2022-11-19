package bridge;

import bridge.domain.BridgeGame;
import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(new BridgeGame());
        bridgeGameController.process();
    }
}
