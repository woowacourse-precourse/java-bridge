package bridge;

import bridge.controller.BridgeGameController;
import bridge.util.BridgeNumberGenerator;

public class Application {

    private static BridgeNumberGenerator bridgeNumberGenerator;

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.start();
    }
}
