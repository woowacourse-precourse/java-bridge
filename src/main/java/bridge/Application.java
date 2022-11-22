package bridge;

import bridge.controller.GamePlayController;

public class Application {

    public static void main(String[] args) {
        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.run();
    }
}
