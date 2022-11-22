package bridge;

import bridge.controller.GameController;
import bridge.domain.User;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        GameController controller = GameController.getInstance();
        BridgeGame game = controller.create();
        controller.operate(user, game);
        controller.finish(user, game);
    }
}
