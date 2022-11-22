package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGameService());
        bridgeGameController.run();
    }

    public static BridgeGameService bridgeGameService() {
        return new BridgeGameService();
    }
}
