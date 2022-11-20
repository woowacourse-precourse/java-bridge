package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.GameRun();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
