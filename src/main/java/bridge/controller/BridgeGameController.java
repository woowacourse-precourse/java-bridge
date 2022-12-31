package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        boolean isSuccess;
        do {
            isSuccess = oneGame(bridgeGame, size);
            if (isSuccess) break;
        } while (initRetryCommand());

        printFinalResult(bridgeGame, isSuccess);
    }

    private void printFinalResult(BridgeGame bridgeGame, boolean isSuccess) {
        OutputView.printResultMessage();
        OutputView.printMap(bridgeGame);
        OutputView.printResult(bridgeGame, isSuccess);
    }

    private boolean oneGame(BridgeGame bridgeGame, int size) {
        bridgeGame.retry();
        for (int idx = 0; idx < size; idx++) {
            boolean moveSuccess = bridgeGame.move(correctBridge, initMoveCommand());
            OutputView.printMap(bridgeGame);
            if (!moveSuccess) return false;
        }
        return true;
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
