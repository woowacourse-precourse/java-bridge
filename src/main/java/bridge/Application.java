package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
