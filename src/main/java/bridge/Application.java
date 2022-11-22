package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.bridge.BridgeRandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        BridgeGameController bridgeGameController
                = new BridgeGameController(new BridgeRandomNumberGenerator());

        try {
            bridgeGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
