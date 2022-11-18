package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.dto.GameResultDto;
import bridge.model.dto.MapDto;
import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        finishGame();
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
                    boolean isMovable = bridgeGame.isMovable(direction);
                    if (isMovable){
                        successToMove(direction);
                        if (bridgeGame.isArrived()) {
                            return;
                        }
                    }
                    if (!isMovable) {
                        failToMove(direction);
                        retryOrQuit();
                        return;
                    }
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_MOVING);
            }
        }
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
        GameResultDto gameResultDto = bridgeGame.finish(gameSuccess);
        outputView.printResult(gameResultDto);
    }

    private void printMap() {
        MapDto map = bridgeGame.createMap();
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
