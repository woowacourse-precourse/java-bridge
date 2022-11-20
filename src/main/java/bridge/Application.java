package bridge;

import bridge.Controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.start();
    }
}
