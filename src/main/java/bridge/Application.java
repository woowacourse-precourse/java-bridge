package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new BridgeGame());
        try {
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
