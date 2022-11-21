package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController.startBridgeGame();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
