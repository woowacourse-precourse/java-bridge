package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.BridgeGameInitializer;
import bridge.model.BridgeGame;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = BridgeGameInitializer.initializeBridgeGame();
        BridgeGameController.start(bridgeGame);
    }
}
