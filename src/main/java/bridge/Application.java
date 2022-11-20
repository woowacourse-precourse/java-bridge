package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeRandomNumberGenerator);
        bridgeGameController.play();
    }
}
