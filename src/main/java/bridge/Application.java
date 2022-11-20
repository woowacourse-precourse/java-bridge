package bridge;

import bridge.engine.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = BridgeGame.init();

        bridgeGame.start();
    }
}
