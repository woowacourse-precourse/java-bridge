package bridge.game;

import bridge.validation.BridgeMoveValidator;
import bridge.validation.BridgeSizeValidator;
import bridge.validation.RetryValidator;
import bridge.view.InputView;

public class Player {
    private static final InputView INPUT_VIEW = new InputView();
    private static final BridgeSizeValidator SIZE_VALIDATOR = new BridgeSizeValidator();
    private static final RetryValidator RETRY_VALIDATOR = new RetryValidator();
    private static final BridgeMoveValidator MOVE_VALIDATOR = new BridgeMoveValidator();

    public static String requestInputSizeToValidation() {
        return SIZE_VALIDATOR.sizeValidator(INPUT_VIEW.readBridgeSize());
    }

    public static String requestInputRetryToValidation() {
        return RETRY_VALIDATOR.retryValidator(INPUT_VIEW.readBridgeSize());
    }

    public static String requestInputMoveToValition() {
        return MOVE_VALIDATOR.moveValidator(INPUT_VIEW.readBridgeSize());
    }
}
