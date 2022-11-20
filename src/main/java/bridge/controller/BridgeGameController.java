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
    private static final String UPSIDE = "U";
    private static final String DOWNSIDE = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final Converter converter = new Converter();

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
        try {
            int bridgeSize = inputView.readBridgeSize();
            checkBridgeSizeAndThrowException(bridgeSize);
            bridgeGame.start(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_BRIDGE_SIZE);
            getBridgeSizeInputAndStartGame();
        }
    }

    private void getMoveInputAndMove(BridgeGame bridgeGame) {
        try {
            getInputAndMove(bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_MOVING);
            getMoveInputAndMove(bridgeGame);
        }
    }

    private void getInputAndMove(BridgeGame bridgeGame) {
        boolean successTf = true;
        while (successTf && !bridgeGame.isArrived()) {
            String moving = inputView.readMoving();
            checkMovingAndThrowException(moving);
            successTf = playGame(bridgeGame, moving);
        }
        if (bridgeGame.isArrived()) {
            GameResultData gameResultData = bridgeGame.finish(successTf);
            outputView.printResult(gameResultData);
        }
        askToRetryOrQuit(bridgeGame);
    }

    private void askToRetryOrQuit(BridgeGame bridgeGame) {
        try {
            String commandLetter = inputView.readGameCommand();
            checkCommandAndThrowException(commandLetter);
            commandGame(bridgeGame, commandLetter);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_COMMAND);
            askToRetryOrQuit(bridgeGame);
        }
    }

    private void checkBridgeSizeAndThrowException(int size) {
        if (!validator.isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMovingAndThrowException(String moving) {
        if (!validator.isValidMoving(moving)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCommandAndThrowException(String letter) {
        if (!validator.isValidCommand(letter)) {
            throw new IllegalArgumentException();
        }
    }
}