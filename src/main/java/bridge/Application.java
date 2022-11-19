package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.initGame();
    }
}
