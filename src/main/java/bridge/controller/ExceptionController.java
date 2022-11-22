package bridge.controller;

import bridge.model.message.Message;
import bridge.model.message.ErrorMessage;

public class ExceptionController {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
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
    private void isValidRange(int size) {
        if (!(BRIDGE_SIZE_MIN <= size && size <= BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException();
        }
    }

}
