package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameController.start();
        boolean alive;
        boolean restart;
        do {
            alive = gameController.play();
            restart = gameController.restart(alive);
        } while (restart);
        gameController.finish(alive);
    }
}
