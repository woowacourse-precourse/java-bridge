package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        try {
            bridgeGameController.run();
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] " + error.getMessage());
        }
    }
}
