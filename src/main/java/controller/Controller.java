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
        try {
            printWelcomeMessage();
            generateBridge(bridgeGame);
            GameStatus gameResult = play(bridgeGame, GameStatus.CONTINUE);
            printResult(gameResult, bridgeGame);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
        }
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
    }

    private void printProgress(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame.getMap());
    }

    private void printResult(final GameStatus gameResult, final BridgeGame bridgeGame) {
        outputView.printResult(gameResult, bridgeGame);
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
        bridgeGame.generateBridge(this.inputView.readBridgeSize());
    }

    private void movePlayer(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        bridgeGame.move(inputView.readMoving());
    }

    private GameStatus getGameStatus(final BridgeGame bridgeGame, boolean playerOnMovableSide) {
        if (!playerOnMovableSide) {
            return askForRetry(bridgeGame);
        }
        return bridgeGame.getGameStatus();
    }

    private GameStatus askForRetry(final BridgeGame bridgeGame) {
        outputView.printAskGameCommand();
        if (bridgeGame.retry(inputView.readGameCommand())) {
            return GameStatus.CONTINUE;
        }
        return GameStatus.FAILURE;
    }
}
