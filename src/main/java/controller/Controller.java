package controller;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import view.InputView;
import view.OutputView;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;

    public Controller(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(final BridgeGame bridgeGame) {
        outputView.printWelcomeMessage();
        generateBridge(bridgeGame);
        GameStatus gameResult = play(bridgeGame, GameStatus.CONTINUE);
        outputView.printResult(gameResult, bridgeGame);
    }

    private GameStatus play(final BridgeGame bridgeGame, GameStatus gameStatus) {
        while (gameStatus == GameStatus.CONTINUE) {
            movePlayer(bridgeGame);
            outputView.printProgress(bridgeGame);
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInMovableSide());
        }
        return gameStatus;
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        try {
            outputView.printAskBridgeLength();
            bridgeGame.generateBridge(this.inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            generateBridge(bridgeGame);
        }
    }

    private void movePlayer(final BridgeGame bridgeGame) {
        try {
            outputView.printAskMoving();
            bridgeGame.move(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            movePlayer(bridgeGame);
        }
    }

    private GameStatus getGameStatus(final BridgeGame bridgeGame, boolean playerOnMovableSide) {
        if (!playerOnMovableSide) {
            return askForRetry(bridgeGame, GameStatus.FAILURE);
        }
        return bridgeGame.getGameStatus();
    }

    private GameStatus askForRetry(final BridgeGame bridgeGame, GameStatus gameStatus) {
        try {
            outputView.printAskGameCommand();
            if (bridgeGame.retry(inputView.readGameCommand())) {
                gameStatus = GameStatus.CONTINUE;
            }
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            return askForRetry(bridgeGame, gameStatus);
        }
        return gameStatus;
    }
}