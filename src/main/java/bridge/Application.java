package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeService bridgeService = new BridgeService();
        BridgeController bridgeController = new BridgeController(bridgeService);
        bridgeController.run();
    }
}
