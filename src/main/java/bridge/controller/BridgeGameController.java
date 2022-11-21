package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.data.GameResultData;
import bridge.model.data.MapData;
import bridge.util.Validator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import static bridge.util.ErrorCode.*;

public class BridgeGameController {
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final String MOVE = "MOVE";
    private static final String FINISH = "FINISH";
    private static final String CANNOT_MOVE = "CANNOT_MOVE";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        outputView.printStartMessage();
        startGame();
        playGame();
    }

    private void startGame() {
        while (true) {
            try {
                int bridgeSize = getInputBridgeSize();
                bridgeGame.start(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_BRIDGE_SIZE);
            }
        }
    }

    private void playGame() {
        while (true) {
            try {
                String direction = getInputDirection();
                String action = decideWhatToDO(direction);
                doAction(direction, action);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_MOVING);
            }
        }
    }

    private String decideWhatToDO(String direction) {
        boolean moveSucceed = bridgeGame.moveSucceed(direction);
        boolean arrived = bridgeGame.isArrived();
        if (arrived)
            return FINISH;
        if (moveSucceed)
            return MOVE;
        return CANNOT_MOVE;
    }

    private void doAction(String direction, String action) {
        if (action == FINISH)
            finishGame(bridgeGame.moveSucceed(direction));
        if (action == MOVE) {
            move(direction);
            playGame();
        }
        if (action == CANNOT_MOVE) {
            bridgeGame.updateRecords(direction, false);
            printMap();
            retryOrQuit();
        }
    }
    private void move(String direction) {
        bridgeGame.move(direction);
        printMap();
    }

    private void finishGame(boolean lastSuccess) {
        GameResultData gameResultData = bridgeGame.finish(lastSuccess);
        outputView.printResult(gameResultData);
    }

    private void printMap() {
        MapData map = bridgeGame.createMap();
        outputView.printMap(map);
    }

    private void retryOrQuit() {
        while (true) {
            try {
                String command = getInputCommandLetter();
                commandGame(command);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_COMMAND);
            }
        }
    }

    private void commandGame(String commandLetter) {
        if (commandLetter.equals(RETRY_COMMAND)) {
            bridgeGame.retry();
            playGame();
        }
        if (commandLetter.equals(QUIT_COMMAND)) {
            bridgeGame.finish(false);
        }
    }

    private int getInputBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();
        validator.validateBridgeSizeAndThrowException(bridgeSize);
        return bridgeSize;
    }

    private String getInputDirection() {
        String moving = inputView.readMoving();
        validator.validateMovingAndThrowException(moving);
        return moving;
    }

    private String getInputCommandLetter() {
        String commandLetter = inputView.readGameCommand();
        validator.validateCommandAndThrowException(commandLetter);
        return commandLetter;
    }
}