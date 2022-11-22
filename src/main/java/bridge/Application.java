package bridge;

import bridge.controller.GameController;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {
        gameController.init();
        gameController.startGame();
        gameController.endGame();
    }

}
