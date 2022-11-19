package bridge;

import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start();
        boolean correct = bridgeGame.move();
        while (correct) {
            correct = bridgeGame.move();
        }
    }
}
