package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        try {
            gameController.gameTotalProgress();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
