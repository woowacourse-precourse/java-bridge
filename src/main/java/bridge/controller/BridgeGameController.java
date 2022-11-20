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
        int bridgeLength = inputView.readBridgeSize();
        bridgeGame.newBridge(bridgeLength);
    }

    public void play() {
        bridgeGame.retry();
        playTurn();
    }

    public void playTurn() {
        newTurn();
        if (!bridgeGame.isSuccess()) {
            askRetry();
            return;
        }
        if (bridgeGame.isSuccess()) {
            turnResult();
        }
    }

    public void newTurn() {
        String nextStep = inputView.readMoving();
        bridgeGame.move(nextStep);
        boolean isSuccess = bridgeGame.isSuccess();
        List<Plate> playerPath = bridgeGame.getPlayerPath();
        outputView.printMap(isSuccess, playerPath);
    }

    public void turnResult() {
        if (bridgeGame.isEndOfBridge()) {
            bridgeGame.victory();
            gameResult();
            return;
        }
        if (!bridgeGame.isEndOfBridge()) {
            playTurn();
        }
    }

    public void askRetry() {
        String retry = inputView.readGameCommand();
        if (retry.equals(Rules.GAME_RETRY)) {
            play();
            return;
        }
        if (retry.equals(Rules.GAME_QUIT)) {
            gameResult();
        }
    }

    public void gameResult() {
        boolean isVictory = bridgeGame.isVictory();
        int tryCount = bridgeGame.getTryCount();
        List<Plate> playerPath = bridgeGame.getPlayerPath();
        outputView.printResult(isVictory, tryCount, playerPath);
    }
}
