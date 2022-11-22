package controller;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
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
        printWelcomeMessage();
        generateBridge(bridgeGame);
        GameStatus gameResult = play(bridgeGame, GameStatus.CONTINUE);
        printResult(gameResult, bridgeGame);
    }

    public GameStatus play(final BridgeGame bridgeGame, GameStatus gameStatus) {
        while (gameStatus == GameStatus.CONTINUE) {
            movePlayer(bridgeGame);
            printProgress(bridgeGame);
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInMovableSide());
        }
        return gameStatus;
    }

    private void printWelcomeMessage() {
        outputView.printGuideMessage(GuideMessage.START);
        outputView.printNewline();
    }

    private void printProgress(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame.getMap());
        outputView.printNewline();
    }

    private void printResult(final GameStatus gameResult, final BridgeGame bridgeGame) {
        outputView.printResult(gameResult, bridgeGame);
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        try {
            outputView.printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
            bridgeGame.generateBridge(this.inputView.readBridgeSize());
            outputView.printNewline();
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            generateBridge(bridgeGame);
        }
    }

    private void movePlayer(final BridgeGame bridgeGame) {
        try {
            outputView.printGuideMessage(GuideMessage.GET_MOVING);
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
        outputView.printAskGameCommand();
        try {
            if (bridgeGame.retry(inputView.readGameCommand())) {
                gameStatus = GameStatus.CONTINUE;
            }
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
            askForRetry(bridgeGame, gameStatus);
        }
        return gameStatus;
    }
}