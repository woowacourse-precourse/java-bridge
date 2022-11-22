package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final String ERROR = "[ERROR] ";

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController () {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void init() {
        try {
            runGame();
        } catch (IllegalArgumentException e) {
            System.out.println( ERROR + e.getMessage());
        }
    }

    private void runGame() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        createBridge(bridgeSize);

        startBridgeGame();
        printGameResult();
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.createBridge(randomBridge);
    }

    private void startBridgeGame() {

        do {
            playEachRound();
            if (isFail()) break;
        } while (isFinalRound());
    }

    private void playEachRound() {
        String moveDirection = inputView.readMoving();
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove(moveDirection);
        outputView.printMap(bridgeRecord);
    }

    private boolean isFail() {
        if (bridgeGame.isFail()) {
            isRestartOrQuit();
            return true;
        }
        return false;
    }

    private void isRestartOrQuit() {
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.isGameRestart(gameCommand)) {
            bridgeGame.retry();
            startBridgeGame();
        }
    }

    private boolean isFinalRound() {
        return bridgeGame.isRoundLeft();
    }

    private void printGameResult() {
        List<List<String>> bridgeRecord = bridgeGame.getBridgeRecord();
        outputView.printFinalRecord(bridgeRecord);

        String scoreMessage = bridgeGame.getScoreMessage();
        int tryCount = bridgeGame.getTryCount();
        outputView.printResult(tryCount, scoreMessage);
    }
}