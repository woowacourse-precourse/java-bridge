package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeService;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new BridgeService());
        bridgeController.run();
    }
}
