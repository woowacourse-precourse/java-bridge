package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
