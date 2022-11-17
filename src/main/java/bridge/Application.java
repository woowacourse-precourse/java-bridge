package bridge;

import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        gameStart(bridgeGame);
    }

    private static void gameStart(BridgeGame bridgeGame) {
        run(bridgeGame);
        while (!bridgeGame.isWin()) {
            if (!bridgeGame.retry()) {
                break;
            }
            run(bridgeGame);
        }
        bridgeGame.finish();
    }

    private static void run(BridgeGame bridgeGame) {
        while (!bridgeGame.isDone()) {
            bridgeGame.move();
        }
    }
}
