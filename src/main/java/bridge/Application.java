package bridge;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {

        BridgeGameService bridgeGameService = new BridgeGameService();

        try {
            BridgeGameController bridgeGameController = new BridgeGameController(bridgeGameService);
            bridgeGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
