package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static List<String> bridge;
    List<Boolean> currentBridge = new ArrayList<>();
    private static int retryCount = 0;

    public void gameStart() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean gameResult;
        gameSetUp();
        do {
            gameResult = oneGame();
            retryCount++;
            if (gameResult) break;
        } while (bridgeGame.retry(initGameCommand()));
        printGameResult(gameResult);
    }

    private void printGameResult(boolean gameResult) {
        OutputView.printMapResult(currentBridge, bridge);
        OutputView.printResult(gameResult);
        OutputView.printTotalCountResult(retryCount);
    }

    private void gameSetUp() {
        OutputView.printGameStartMessage();
        int size = initSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    private int initSize() {
        String bridgeSize = "";
        try {
            bridgeSize = InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    private String initMoving() {
        String moveCommand;
        try {
            moveCommand = InputView.readMoving();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initMoving();
        }
        return moveCommand;
    }

    private String initGameCommand() {
        String moveCommand;
        try {
            moveCommand = InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initGameCommand();
        }
        return moveCommand;
    }

    private boolean oneGame() {
        currentBridge.clear();
        for (int idx = 0; idx < bridge.size(); idx++) {
            boolean result = moveBridge(idx);
            currentBridge.add(result);
            OutputView.printTopMap(currentBridge, bridge);
            OutputView.printBottomMap(currentBridge, bridge);
            if (!result) return false;
        }
        return true;
    }

    private boolean moveBridge(int idx) {
        BridgeGame bridgeGame = new BridgeGame();

        String moveCommand = initMoving();
        return bridgeGame.move(moveCommand, bridge.get(idx));
    }
}
