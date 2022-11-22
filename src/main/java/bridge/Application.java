package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        controller.start();
        controller.setDifficulty();
        do {
            controller.playGame();
        } while (controller.askRetry());
        controller.end();
    }
}
