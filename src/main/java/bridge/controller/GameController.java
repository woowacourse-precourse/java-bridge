package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.GameOption;
import bridge.service.BridgeGame;
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
            startBridgeGame();
            printGameResult();
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
        } while (isRoundLeft());
    }

    private void playEachRound() {
        String moveDirection = inputView.readMoving();
        List<List<String>> bridgeRecord = bridgeGame.judgeResultByMove(moveDirection);
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
        if (GameOption.isGameRestart(gameCommand)) {
            bridgeGame.retry();
            startBridgeGame();
        }
    }

    private boolean isRoundLeft() {
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