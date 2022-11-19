package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            final GameController gameController = new GameController();
            gameController.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }
}
