package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.TotalResult;

public class Application {
    public static void main(String[] args) {
        TotalResult result = BridgeGameController.start();
        BridgeGameController.printResult(result);
    }
}
