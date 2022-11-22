package bridge.controller;

import bridge.model.message.Message;
import bridge.model.message.ErrorMessage;

public class ExceptionController {
    public ExceptionController() {
    }

    public void checkBridgeSize(String input) {
        try {
            int size = Integer.parseInt(input);
            isValidRange(size);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = ErrorMessage.ERROR_PREFIX.getErrorMessage() + ErrorMessage.ERROR_BRIDGE_SIZE.getErrorMessage();
            throw new IllegalArgumentException(message);
        }
    }
    public void checkMoving(final String input) {
        if (!isValidMoving(input)) {
            String message = ErrorMessage.ERROR_PREFIX.getErrorMessage() + ErrorMessage.ERROR_MOVING.getErrorMessage();
            throw new IllegalArgumentException(message);
        }
    }

}
