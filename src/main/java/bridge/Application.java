package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        try {
            bridgeGameController.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
