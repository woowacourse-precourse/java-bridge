package bridge;

import bridge.controller.BridgeGameController;
import bridge.enums.InputExceptionConstants;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(InputExceptionConstants.ERROR.getMessage() + e.getMessage());
        }
    }
}
