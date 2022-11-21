package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.run();
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
