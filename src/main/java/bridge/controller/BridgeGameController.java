package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.validator.CommandValidator.validateInvalidRetryType;
import static bridge.validator.CommandValidator.validateInvalidType;
import static bridge.validator.NumberValidator.validateNonNumeric;
import static bridge.validator.NumberValidator.validateRange;

public class BridgeGameController {
    private final static String RETRY = "R";
    private static Bridge correctBridge;

    public void gameStart() {
        int size = initBridgeSize();
        initBridge(size);
        BridgeGame bridgeGame = new BridgeGame();
        boolean gameResult;
        do {
            gameResult = oneGame();
            retryCount++;
            if (gameResult) break;
        } while (initRetryCommand());
        printGameResult(gameResult);
    }

    private void printGameResult(boolean gameResult) {
        OutputView.printMapResult(currentBridge, bridge);
        OutputView.printResult(gameResult);
        OutputView.printTotalCountResult(retryCount);
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

        String moveCommand = initMoveCommand();
        return bridgeGame.move(moveCommand, bridge.get(idx));
    }

    private boolean initRetryCommand() {
        String retryCommand;
        try {
            retryCommand = InputView.readGameCommand();
            validateInvalidRetryType(retryCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initRetryCommand();
        }
        return retryCommand.equals(RETRY);
    }

    private String initMoveCommand() {
        String moveCommand;
        try {
            moveCommand = InputView.readMoving();
            validateInvalidType(moveCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initMoveCommand();
        }
        return moveCommand;
    }

    private void initBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        correctBridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    private int initBridgeSize() {
        String bridgeSize;
        try {
            bridgeSize = InputView.readBridgeSize();
            validateNonNumeric(bridgeSize);
            validateRange(bridgeSize);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }
}
