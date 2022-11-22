package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        BridgeGame game = controller.create();
        controller.operate(game);
        controller.finish(game);
    }
}
