package bridge;

import bridge.controller.BridgeGame;

public class Application {
    private final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        bridgeGame.start();
    }
}
