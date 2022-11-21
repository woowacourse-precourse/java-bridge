package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.SuccessOrFail;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.createBridge();
        bridgeGameController.playGame(0,0);
    }
}
