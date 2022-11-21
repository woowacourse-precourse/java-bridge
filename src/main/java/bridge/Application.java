package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
            gameController.run();
        // TODO: 프로그램 구현
    }
}
