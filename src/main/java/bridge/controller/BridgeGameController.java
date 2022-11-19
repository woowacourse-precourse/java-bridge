package bridge.controller;

import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    GameStatus gameStatus;

    public void run() {
        start();
        play();
    }

    private void play() {
        bridgeGame.newGame();
        gameStatus = GameStatus.PLAYING;
        while (gameStatus == GameStatus.PLAYING) {
            moveBridge();
        }

        if (gameStatus == GameStatus.FAIL) {
            askRetry();
        }
    }

    private void askRetry() {
        gameStatus = inputView.printAskRetry();

        if (gameStatus == GameStatus.RETRY) {
            play();
        }
    }

    private void moveBridge() {
        gameStatus = bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getPlayerMoveResult());
    }

    private void start() {
        outputView.printStart();
        bridgeGame.createBridge(inputView.readBridgeSize());
    }
}
