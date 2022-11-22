package bridge;

import bridge.controller.BridgeController;
import bridge.model.enumeration.ExceptionMessage;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();

        try {
            bridgeController.init();
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.PREFIX.getExceptionMessage() + e.getMessage());
        }
    }
}