package bridge;

import controller.BridgeController;

public class Application {

    public static void main(String[] args) {

        try {
            BridgeController.printStart();
            BridgeController bridgeController = new BridgeController();
            bridgeController.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
