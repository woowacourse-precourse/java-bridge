package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {

    private static BridgeGame bridgeGame = new BridgeGame();
    private static boolean retryGame = true;

    public static void startBridgeGame() {
        OutputView.showGameStartMessage();
        bridgeGame.initGame(InputView.readBridgeSize());
        while (bridgeGame.onGame() && retryGame) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getMap());
            if (bridgeGame.checkBridge()) {
                retryGame = bridgeGame.retry(InputView.readGameCommand());
            }
        }
        OutputView.printResult(bridgeGame.onGame(), bridgeGame.getRetryCount(), bridgeGame.getMap());
    }

    public static void run() {
        try {
            startBridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
