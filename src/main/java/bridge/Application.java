package bridge;

import bridge.domain.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController gameController = new BridgeGameController();
        gameController.start();
    }
}
