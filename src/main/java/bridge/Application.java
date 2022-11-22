package bridge;

import bridge.controller.GameController;
import bridge.domain.player.Player;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameController gameController = new GameController(player, bridgeMaker);

        gameController.run();
    }
}
