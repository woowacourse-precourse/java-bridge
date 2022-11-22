package bridge;

import bridge.controller.BridgeController;
import bridge.model.enumeration.ExceptionMessage;

import static bridge.controller.BridgeController.outputView;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        outputView.printInit();

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