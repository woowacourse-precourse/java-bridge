package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static bridge.validator.BlockValidator.validateInvalidType;

public class BridgeGameController {
    private static List<String> bridge;
    List<Boolean> currentBridge = new ArrayList<>();
    private static int retryCount = 0;

    public void gameStart() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean play = false;
        boolean gameResult;
        gameSetUp();
        do {
            gameResult = oneGame();
            retryCount++;
            if (gameResult) break;
            String retryCommand = initGameCommand();
            play = bridgeGame.retry(retryCommand);
        } while (play);
        printGameResult(gameResult);
    }

    private void printGameResult(boolean gameResult) {
        OutputView.printMapResult(currentBridge, bridge);
        OutputView.printResult(gameResult);
        OutputView.printTotalCountResult(retryCount);
    }

    private List<String> gameSetUp() {
        OutputView.printGameStartMessage();
        int size = initSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
        return bridge;
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
        BridgeGame bridgeGame = new BridgeGame();
        currentBridge.clear();
        int currentIndex = 0;
        boolean result = true;
        for (int i = 0; i < bridge.size(); i++) {
            String moveCommand = initMoving();
            result = bridgeGame.move(currentIndex, moveCommand, bridge);
            currentBridge.add(result);
            currentIndex++;
            OutputView.printMap(currentBridge, bridge);
            if (!result) return false;
        }
        return true;
    }
}
