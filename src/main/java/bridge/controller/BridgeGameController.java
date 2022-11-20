package bridge.controller;

import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    GameStatus gameStatus = GameStatus.PLAYING;

    public void run() {
        start();
        play();
    }

    private void play() {
        while (gameStatus == GameStatus.PLAYING) {
            moveBridge();
            if (gameStatus == GameStatus.FAIL) {
                askRetry();
            }
        }
    }

    private void askRetry() {
        gameStatus = bridgeGame.retry(InputView.printAskRetry());
    }

    private void moveBridge() {
        gameStatus = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(bridgeGame.getPlayerMoveResult());
    }

    private void start() {
        OutputView.printStart();
        bridgeGame.createBridge(InputView.readBridgeSize());
    }
}
