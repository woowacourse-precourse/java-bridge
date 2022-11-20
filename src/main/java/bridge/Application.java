package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameController controller = new BridgeGameController(bridgeGame);
        controller.run();
    }
}
