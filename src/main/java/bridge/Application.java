package bridge;

import bridge.controller.BridgeGameController;

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
