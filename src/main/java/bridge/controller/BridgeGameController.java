package bridge.controller;

import bridge.domain.MovingResult;
import bridge.generators.MessageGenerator;
import bridge.service.BridgeGame;
import bridge.validator.InputValidator;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {
    public static final String RETRY = "R";

    private final BridgeGame bridgeGameService = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartMessage();
        requestGenerateBridge();
    }

    private void requestGenerateBridge() {
        try {
            bridgeGameService.generateRandomBridge(requestBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestGenerateBridge();
        }
        requestBlock();
    }

    private void requestBlock() {
        try {
            bridgeGameService.move(inputView.readMoving());
            responseMovingResult();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestBlock();
        }
    }

    private void responseMovingResult() {
        MovingResult movingResult = bridgeGameService.createMovingResult();
        outputView.printMovingResult(MessageGenerator.createMovedMessage(movingResult));
        if (movingResult.isFailToMove()) {
            requestPlayingAgain();
            return;
        }
        requestBlock();
    }

    private void requestPlayingAgain() {
        try {
            if (InputValidator.validateGameCommand(inputView.readGameCommand()).equals(RETRY)) {
                bridgeGameService.retry();
            }
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestPlayingAgain();
        }
    }

    private String requestBridgeSize() {
        return inputView.readBridgeSize();
    }

}
