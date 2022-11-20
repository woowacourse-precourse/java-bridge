package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        try {
            bridgeController.startController();
            bridgeController.setBridgeController();
            bridgeController.moveController();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
