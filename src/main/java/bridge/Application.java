package bridge;

import bridge.Controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.GAMESTART();
        do {
            gameController.RUNPROCESS();
        } while (gameController.SELECTRESTART());
    }
}
