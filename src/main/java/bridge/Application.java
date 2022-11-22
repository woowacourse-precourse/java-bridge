package bridge;

import bridge.config.Config;
import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = Config.gameController();
        gameController.start();
    }
}
