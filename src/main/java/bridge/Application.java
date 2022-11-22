package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();

        controller.run();
    }
}
