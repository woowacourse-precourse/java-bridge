package bridge;

import bridge.controller.GameController;
import bridge.controller.InputController;

public class Application {

    public static void main(String[] args) {

        InputController inputController = new InputController();
        GameController gameController = new GameController(inputController);
        gameController.run();
    }
}
