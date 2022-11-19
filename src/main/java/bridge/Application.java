package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.game.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController(new BridgeGame());
        controller.run();
    }
}
