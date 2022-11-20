package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeGame;
import bridge.model.Player;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        Player player = new Player();
        BridgeGameController controller = new BridgeGameController(bridgeGame, player);
        controller.run();
    }
}
