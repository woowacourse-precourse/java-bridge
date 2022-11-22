package bridge;

import bridge.ui.controller.BridgeGameController;

public class Application {
    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.initGame();

        bridgeGameController.play();

        int count = bridgeGameController.getCount();
        bridgeGameController.endGame(count);
    }

}
