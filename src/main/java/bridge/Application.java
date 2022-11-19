package bridge;

import bridge.controller.BridgeGame;

import java.util.Map;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        oneGame(bridgeGame);
    }

    private static void oneGame(BridgeGame bridgeGame) {
        while (true) {
            Map<String, Boolean> move = bridgeGame.move();
            boolean isEnd = move.get("isGameEnd");
            if (isEnd)
                break;
        }
    }

    private static void restartOrStop(BridgeGame bridgeGame) {

    }
}
