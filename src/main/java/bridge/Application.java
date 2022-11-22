package bridge;

import bridge.domain.BridgeGameManager;

public class Application {

    public static void main(String[] args) {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        bridgeGameManager.start();
    }
}
