package bridge;

import bridge.config.GameConfig;
import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameConfig gameConfig = new GameConfig();
        GameController gameController = gameConfig.gameController();
        gameController.start();
    }
}
