package bridge;

import bridge.controller.game.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.play();
    }
}
