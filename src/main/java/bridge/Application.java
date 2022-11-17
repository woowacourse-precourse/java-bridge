package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.BridgeGame;
import bridge.model.BridgeRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController=new BridgeGameController();
        bridgeGameController.startBridgeGame();
    }
}
