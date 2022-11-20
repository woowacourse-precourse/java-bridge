package bridge.controller;

import static bridge.messages.ErrorMessage.*;

import bridge.service.BridgeGame;
import bridge.validator.InputValidator;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGameService = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartMessage();
        requestGenerateBridge();
    }

    private void requestGenerateBridge() {
        try {
            bridgeGameService.generateRandomBridge(InputValidator.validateBridgeSize(requestBridgeSize()));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestGenerateBridge();
        }
    }

    private int requestBridgeSize() {
        try {
            return Integer.parseInt(inputView.readBridgeSize());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMERIC_BRIDGE_SIZE_ERROR);
        }
    }

}
