package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.run();
    }
}
