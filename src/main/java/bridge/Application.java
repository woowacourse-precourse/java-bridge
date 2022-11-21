package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController();
        gameController.runGameMain();
    }
}
