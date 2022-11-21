package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        BridgeGameController controller = new BridgeGameController(game);
        controller.run();
    }
}