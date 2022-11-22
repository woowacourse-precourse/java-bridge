package bridge;

import bridge.controller.BridgeGameController;

import static bridge.controller.BridgeGameController.bridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGame();
    }
}
