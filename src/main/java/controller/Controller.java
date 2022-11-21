package controller;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import view.InputView;
import view.OutputView;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;

    public Controller(OutputView outputView, InputView inputView) {
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
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInRightSide());
        }
        return gameStatus;
    }

    private void printWelcomeMessage() {
        outputView.printGuideMessage(GuideMessage.START);
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
        bridgeGame.generateBridge(this.inputView.readBridgeSize());
    }

    private void printProgress(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame.getMap());
    }

    private void movePlayer(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_MOVING);
        bridgeGame.move(inputView.readMoving());
    }

    private GameStatus getGameStatus(final BridgeGame bridgeGame, boolean moved) {
        if (!moved) {
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

    private void printResult(GameStatus gameResult, BridgeGame bridgeGame) {
        outputView.printResult(gameResult, bridgeGame);
    }

}
