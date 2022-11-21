package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.util.AppCofig;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController bridgeGameController = AppCofig.createBridgeGameController();
        bridgeGameController.run();
    }
}
