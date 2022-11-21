package controller;

import bridge.BridgeGame;
import enumCollections.GameStatus;
import enumCollections.GuideMessage;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;

    public Controller(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame(final BridgeGame bridgeGame) {
        try {
            outputView.printGuideMessage(GuideMessage.START);
            generateBridge(bridgeGame);
            play(bridgeGame, GameStatus.CONTINUE);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception);
        }
    }

    public GameStatus play(final BridgeGame bridgeGame, GameStatus gameStatus) {
        while (gameStatus == GameStatus.CONTINUE) {
            movePlayer(bridgeGame);
            getProgress(bridgeGame);
            gameStatus = getGameStatus(bridgeGame, bridgeGame.isPlayerInRightSide());
        }
        getResult(gameStatus, bridgeGame, bridgeGame.getMap());
        return gameStatus;
    }

    private void generateBridge(final BridgeGame bridgeGame) {
        outputView.printGuideMessage(GuideMessage.GET_BRIDGE_LENGTH);
        bridgeGame.generateBridge(this.inputView.readBridgeSize());
    }

    private void getProgress(BridgeGame bridgeGame) {
        bridgeGame.updateMap();
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

    private void getResult(GameStatus gameResult, BridgeGame bridgeGame, List<List<String>> map) {
        outputView.printGuideMessage(GuideMessage.RESULT_PRINT);
        outputView.printMap(bridgeGame.getMap());
        outputView.printNewline();
        outputView.printResult(gameResult);
        outputView.printGuideMessage(GuideMessage.GAME_TRIAL, bridgeGame.getTrial());
    }
}
