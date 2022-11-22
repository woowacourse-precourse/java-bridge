package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.play();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println("--프로그램 종료--");
        }
    }
}
