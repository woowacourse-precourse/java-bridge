package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.gameStart();
        }catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}

