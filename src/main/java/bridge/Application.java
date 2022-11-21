package bridge;


import bridge.config.BridgeConfig;
import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeConfig config = new BridgeConfig();

        BridgeController controller = config.bridgeController();
        controller.playWithExceptionCatch();
    }
}
