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

    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public void run() {
        outputView.printStartMessage();
        startGame();
        playGame();
        finishGame();
    }

    private void startGame() {
        while (true) {
            try {
                bridgeGame.start(getInputBridgeSize());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_BRIDGE_SIZE);
            }
        }
    }

    private void playGame() {
        while (true) {
            try {
                if (!continueGettingInput())
                    return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_MOVING);
            }
        }
    }

    private boolean continueGettingInput() {
        String direction = getInputDirection();
        boolean isMovable = bridgeGame.isMovable(direction);

        doProperAction(direction, isMovable);

        if (isMovable && !bridgeGame.isArrived())
            return true;
        return false;
    }

    private void doProperAction(String direction, boolean movable) {
        if (movable) {
            successToMove(direction);
            return;
        }
        failToMove(direction);
        retryOrQuit();
    }

    private void successToMove(String direction) {
        bridgeGame.move(direction);
        printMap();
    }

    private void failToMove(String direction) {
        bridgeGame.updateRecords(direction, false);
        printMap();
    }

    private void finishGame() {
        boolean gameSuccess = bridgeGame.isArrived();
        GameResultData gameResultData = bridgeGame.finish(gameSuccess);
        outputView.printResult(gameResultData);
    }

    private void printMap() {
        MapData map = bridgeGame.createMap();
        outputView.printMap(map);
    }

    private void retryOrQuit() {
        while (true) {
            try {commandGame(getInputCommandLetter());
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
            return;
        }
        bridgeGame.finish(false);
    }

    private int getInputBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();
        validator.validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    private String getInputDirection() {
        String moving = inputView.readMoving();
        validator.validateDirection(moving);
        return moving;
    }

    private String getInputCommandLetter() {
        String commandLetter = inputView.readGameCommand();
        validator.validateCommand(commandLetter);
        return commandLetter;
    }
}