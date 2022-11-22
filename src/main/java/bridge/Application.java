package bridge;

import bridge.controller.BridgeController;

public class Application {
    public static void main(String[] args) {
        try {
            BridgeController bridgeController = new BridgeController();
            bridgeController.runGame();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

    }
}
