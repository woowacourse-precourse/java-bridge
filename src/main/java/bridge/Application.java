package bridge;

import bridge.presentation.GameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController=GameController.getInstance();
        gameController.run();
        gameController.inputBridgeSize();
    }
}
