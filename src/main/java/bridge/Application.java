package bridge;

import bridge.config.Config;
import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Config config = new Config();
        BridgeGameController bridgeGameController = config.setBridgeGameController();
        bridgeGameController.run();
    }
}
