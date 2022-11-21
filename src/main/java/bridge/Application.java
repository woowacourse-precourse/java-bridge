package bridge;

import bridge.controller.GameController;
import bridge.domain.player.Player;
import bridge.view.ExceptionView;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameController gameController = new GameController(player, bridgeMaker);

        try {
            gameController.run();
        } catch (IllegalArgumentException e) {
            ExceptionView.print(e.getMessage());
        }
    }
}
