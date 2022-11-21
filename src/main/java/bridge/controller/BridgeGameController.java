package bridge.controller;

import bridge.domain.GameProgress;
import bridge.domain.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    GameStatus gameStatus = GameStatus.PLAYING;
    GameProgress gameProgress = GameProgress.START;

    public void run() {
        OutputView.printStart();

        while (gameProgress != GameProgress.EXIT) {
            try {
                choiceGameMode();
            } catch (IllegalArgumentException ex) {
                OutputView.printError(ex.getMessage());
            }
        }
    }

    private void choiceGameMode() {
        if (gameProgress == GameProgress.START) {
            start();
        }
        if (gameProgress == GameProgress.PLAY) {
            play();
        }
        if (gameProgress == GameProgress.END) {
            end();
        }
    }

    private void end() {
        OutputView.printResult(bridgeGame.getPlayer(), GameStatus.decideGameResult(gameStatus));

        gameProgress = GameProgress.EXIT;
    }

    private void play() {
        while (gameStatus == GameStatus.PLAYING) {
            moveBridge();
            if (gameStatus == GameStatus.DEATH) {
                askRetry();
            }
        }

        gameProgress = GameProgress.END;
    }

    private void askRetry() {
        gameStatus = bridgeGame.retry(InputView.printAskRetry());
    }

    private void moveBridge() {
        gameStatus = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(bridgeGame.getPlayer());
    }

    private void start() {
        bridgeGame.createBridge(InputView.readBridgeSize());
        gameProgress = GameProgress.PLAY;
    }
}
