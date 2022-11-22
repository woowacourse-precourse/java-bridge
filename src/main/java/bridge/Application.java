package bridge;

import bridge.controller.BridgeController;
import bridge.model.enumeration.ExceptionMessage;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        while (true) {
            try {
                bridgeController.init();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionMessage.PREFIX.getExceptionMessage() + e.getMessage());
            }
        }
    }
}