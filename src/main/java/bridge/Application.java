package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new BridgeRandomNumberGenerator());
        try {
            gameController.playGame();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
