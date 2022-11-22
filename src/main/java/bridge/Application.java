package bridge;

import bridge.game.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGame bridgeGame = new BridgeGame(randomNumberGenerator);
        bridgeGame.start();
    }
}
