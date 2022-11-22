package bridge.controller;

import bridge.domain.status.GameStatus;
import bridge.domain.status.UserStatus;
import bridge.exception.ExceptionMessage;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void init() {
        try {
            String size = inputView.readBridgeSize();
            outputView.printEmptyLine();
            validateBridgeSize(size);

            int bridgeSize = Integer.parseInt(size);
            bridgeGame = new BridgeGame(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            init();
        }
    }

    public void start() {
        outputView.printStartMessage();
        init();
    }

    public void run() {
        start();
        while (bridgeGame.isProceed()) {
            play();

            if (bridgeGame.retry()) {
                bridgeGame.resetUserData();
                bridgeGame.changeGameStatus(GameStatus.PROCEED);
            }
            checkSuccess();
        }
        quit();
    }

    public void play() {
        String moveInput = inputView.readMoving();
        try {
            UserStatus userStatus = bridgeGame.move(moveInput);
            outputView.printMap(bridgeGame.getUserPathLog());
            checkRetry(userStatus);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            play();
        }
    }

    public void checkSuccess() {
        if (bridgeGame.isSuccess()) {
            bridgeGame.changeGameStatus(GameStatus.SUCCESS);
            String userPathLog = bridgeGame.getUserPathLog();
            outputView.printResult(userPathLog, bridgeGame.getResultStatus(), bridgeGame.getTryCount());
        }
    }

    public void quit() {
        if (bridgeGame.isSuccess()) {
            return;
        }
        bridgeGame.changeGameStatus(GameStatus.FAIL);
        String userPathLog = bridgeGame.getUserPathLog();
        outputView.printResult(userPathLog, bridgeGame.getResultStatus(), bridgeGame.getTryCount());
    }

     private void checkRetry(UserStatus userStatus) {
        try {
            if (userStatus.checkUserStatus(UserStatus.OUT)) {
                String inputGameStatus = inputView.readGameCommand();
                GameStatus gameStatus = GameStatus.convertGameStatus(inputGameStatus);
                bridgeGame.changeGameStatus(gameStatus);
            }
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            checkRetry(userStatus);
        }
    }

    // 검증 메서드
    public void validateBridgeSize(String size) {
        validateBridgeSizeIsNull(size);
        validateBridgeSizeIsNumeric(size);
        validateBridgeSizeRange(size);
    }

    public void validateBridgeSizeIsNull(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_IS_NULL_ERROR));
        }
    }

    public void validateBridgeSizeIsNumeric(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_IS_NOT_NUMBER_ERROR));
        }
    }

    public void validateBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);

        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(String.valueOf(ExceptionMessage.BRIDGE_SIZE_RANGE_ERROR));
        }
    }
}
