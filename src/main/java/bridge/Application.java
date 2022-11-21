package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        final BridgeGameController bridgeGameController = new BridgeGameController();
        
        bridgeGameController.initializeGame();
        bridgeGameController.playGame();
        bridgeGameController.terminateGame();
    }
}
