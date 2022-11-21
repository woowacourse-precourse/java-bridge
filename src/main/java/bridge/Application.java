package bridge;

import bridge.controlloer.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.play();
    }
}
