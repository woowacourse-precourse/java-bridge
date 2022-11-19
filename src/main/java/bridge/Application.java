package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        oneGame(bridgeGame);
    }

    private static void oneGame(BridgeGame bridgeGame) {
        while (true) {
            boolean isEnd = bridgeGame.move();
            if (isEnd)
                break;
        }
    }
}
