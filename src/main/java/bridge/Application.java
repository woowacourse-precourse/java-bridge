package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = new BridgeGame(bridgeNumberGenerator);
        bridgeGame.start();
    }
}
