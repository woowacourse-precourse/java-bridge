package bridge;

import bridge.Controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.playGame();
    }
}
