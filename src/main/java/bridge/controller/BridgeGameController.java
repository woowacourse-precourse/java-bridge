package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Plate;
import bridge.util.Rules;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void startNewGame() {
        outputView.printStart();
    }

    public void createNewBridge() {
        try {
            int bridgeLength = inputView.readBridgeSize();
            bridgeGame.newBridge(bridgeLength);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            createNewBridge();
        }
    }

    public void play() {
        bridgeGame.retry();
        playRound();
    }

    public void playRound() {
        selectPlate();
        if (!bridgeGame.isSuccess()) {
            askRetry();
            return;
        }
        if (bridgeGame.isSuccess()) {
            turnResult();
        }
    }

    public void selectPlate() {
        try {
            String nextStep = inputView.readMoving();
            bridgeGame.move(nextStep);
            outputView.printMap(bridgeGame.isSuccess(), bridgeGame.getPlayerPath());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            selectPlate();
        }
    }

    public void turnResult() {
        if (bridgeGame.isEndOfBridge()) {
            bridgeGame.victory();
            gameResult();
            return;
        }
        if (!bridgeGame.isEndOfBridge()) {
            playRound();
        }
    }

    public void askRetry() {
        try {
            String retry = inputView.readGameCommand();
            if (retry.equals(Rules.GAME_RETRY)) {
                play();
                return;
            }
            if (retry.equals(Rules.GAME_QUIT)) {
                gameResult();
            }
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            askRetry();
        }
    }

    public void gameResult() {
        boolean isVictory = bridgeGame.isVictory();
        int tryCount = bridgeGame.getTryCount();
        List<Plate> playerPath = bridgeGame.getPlayerPath();
        outputView.printResult(isVictory, tryCount, playerPath);
    }
}
