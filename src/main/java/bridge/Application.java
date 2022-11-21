package bridge;

import controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();

        bridgeController.makeBridge();
        bridgeController.startGame();
    }
}
