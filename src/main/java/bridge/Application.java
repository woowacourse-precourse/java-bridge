package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
