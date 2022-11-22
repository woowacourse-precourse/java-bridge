package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.startGame();
        bridgeController.makeBridge();
        bridgeController.run();
        bridgeController.showFinalResult();
    }
}
