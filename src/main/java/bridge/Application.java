package bridge;

import bridge.controller.BridgeGameManager;

public class Application {

    public static void main(String[] args) {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        bridgeGameManager.play();
    }
}
