package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.MapMaker;
import bridge.model.data.GameResultData;
import bridge.model.data.MapData;
import bridge.util.Converter;
import bridge.util.Validator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.util.ErrorCode.*;

public class BridgeGameController {
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        outputView.printStartMessage();
        getBridgeSizeInputAndStartGame();
        getMoveInputAndMove(bridgeGame);
    }

    private void commandGame(BridgeGame bridgeGame, String commandLetter) {
        if (commandLetter.equals(RETRY_COMMAND)) {
            bridgeGame.retry();
            getMoveInputAndMove(bridgeGame);
        }
    }

    private boolean playGame(BridgeGame bridgeGame, String moving) {
        boolean moveSuccess = bridgeGame.move(moving);
        bridgeGame.updateRecords(moving, moveSuccess);

        MapData mapData = bridgeGame.createMap();
        outputView.printMap(mapData);

        return moveSuccess;
    }

    private void getBridgeSizeInputAndStartGame() {
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

    private int getInputBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();
        validator.validateBridgeSizeAndThrowException(bridgeSize);
        return bridgeSize;
    }

    private void getMoveInputAndMove(BridgeGame bridgeGame) {
        while (true) {
            try {
                getInputAndMove(bridgeGame);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_MOVING);
            }
        }
    }

    private void getInputAndMove(BridgeGame bridgeGame) {
        boolean successTf = true;
        while (successTf && !bridgeGame.isArrived()) {
            String moving = inputView.readMoving();
            validator.validateMovingAndThrowException(moving);
            successTf = playGame(bridgeGame, moving);
        }
        if (bridgeGame.isArrived()) {
            GameResultData gameResultData = bridgeGame.finish(successTf);
            outputView.printResult(gameResultData);
        }
        if (!successTf && !bridgeGame.isArrived()) {
            askToRetryOrQuit(bridgeGame);
        }
    }

    private void askToRetryOrQuit(BridgeGame bridgeGame) {
        while (true) {
            try {
                String command = getInputCommandLetter();
                commandGame(bridgeGame, command);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(INVALID_COMMAND);
            }
        }
    }

    private String getInputCommandLetter() {
        String commandLetter = inputView.readGameCommand();
        validator.validateCommandAndThrowException(commandLetter);
        return commandLetter;
    }
}