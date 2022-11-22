package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        controller.start();
        controller.setDifficulty();
        do {
            controller.playGame();
            if(controller.isSuccess())
                break;
        } while (controller.askRetry());
        controller.end();
    }
}
