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
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

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
        return inputView.readMoving();
    }

    private void playRound() {
        String moveDirection = loadMoveDirection();
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
            startGame();
        }
    }

    private boolean isFinalRound() {
        return bridgeGame.isRoundLeft();
    }

    private void printGameResult() {
        Record record = bridgeGame.getRecord();
        List<List<String>> bridgeRecord = record.getBridgeRecord();
        outputView.printFinalResult(bridgeRecord);

        Result result = bridgeGame.getResult();
        outputView.printResult(result);
    }
}