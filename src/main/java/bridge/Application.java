package bridge;

import bridge.config.BridgeConfig;
import bridge.controller.BridgeController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeConfig bridgeConfig = new BridgeConfig();

        BridgeController bridgeController =bridgeConfig.bridgeController();

        bridgeController.playWithExceptionCatch();
    }
}
