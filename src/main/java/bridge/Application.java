package bridge;

import bridge.controller.GameController;
import bridge.domain.Bridge;
import bridge.domain.User;

public class Application {

    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        User user = new User();
        Bridge map = controller.createMap();
        controller.operate(map, user);
        controller.finish(map, user);
    }
}
