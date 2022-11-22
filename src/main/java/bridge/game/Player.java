package bridge.game;

import bridge.validator.BridgeMoveValidator;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.RetryValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Player {
    private static final InputView INPUT_VIEW = new InputView();
    private static final BridgeSizeValidator SIZE_VALIDATOR = new BridgeSizeValidator();
    private static final RetryValidator RETRY_VALIDATOR = new RetryValidator();
    private static final BridgeMoveValidator MOVE_VALIDATOR = new BridgeMoveValidator();

    public static String requestInputSizeToValidation() {
        try {
            return SIZE_VALIDATOR.sizeValidator(INPUT_VIEW.readBridgeSize());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return requestInputSizeToValidation();
        }
    }

    public static String requestInputRetryToValidation() {
        try {
            return RETRY_VALIDATOR.retryValidator(INPUT_VIEW.readGameCommand());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return requestInputRetryToValidation();
        }
    }

    public static String requestInputMoveToValidation() {
        try {
            return MOVE_VALIDATOR.moveValidator(INPUT_VIEW.readMoving());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return requestInputMoveToValidation();
        }
    }
}
