package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.Record;
import bridge.model.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final String ERROR = "[ERROR] ";

    private BridgeGame bridgeGame = new BridgeGame();

    public void init() {
        try {
            runGame();
        } catch (IllegalArgumentException e) {
            System.out.println( ERROR + e.getMessage());
        }
    }

    private void runGame() {
        OutputView.printStart();
        int bridgeSize = InputView.readBridgeSize();
        createBridge(bridgeSize);

        startGame();
        printGameResult();
    }

    private void startGame() {

        do {
            playRound();
            if (isFail()) break;
        } while (isFinalRound());
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.createBridge(randomBridge);
    }

    private String loadMoveDirection() {
        return InputView.readMoving();
    }

    private void playRound() {
        String moveDirection = loadMoveDirection();
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove(moveDirection);
        OutputView.printMap(bridgeRecord);
    }

    private boolean isFail() {
        if (bridgeGame.isPass()) {
            return false;
        }
        isRestartOrQuit();
        return true;
    }

    private boolean isRestartOrQuit() {
        String gameCommand = InputView.readGameCommand();
        if (bridgeGame.isGameRestart(gameCommand)) {
            bridgeGame.retry();
            startGame();
            return false;
        }
        return true;
    }

    private boolean isFinalRound() {
        return bridgeGame.isRoundLeft();
    }

    private void printGameResult() {
        Record record = bridgeGame.getRecord();
        List<List<String>> bridgeRecord = record.getBridgeRecord();
        OutputView.printFinalResult(bridgeRecord);

        Result result = bridgeGame.getResult();
        OutputView.printResult(result);
    }
}