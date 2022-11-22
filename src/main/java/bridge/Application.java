package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.run();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
