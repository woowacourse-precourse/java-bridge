package bridge;

import bridge.controller.BridgeController;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeController bridgeController = new BridgeController();
            bridgeController.run();
        }catch(IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
        }
    }
}
