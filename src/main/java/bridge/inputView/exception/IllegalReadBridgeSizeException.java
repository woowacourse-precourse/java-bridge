package bridge.inputView.exception;

import bridge.common.ErrorMessage;

public class IllegalReadBridgeSizeException extends IllegalArgumentException {
    private static final String MESSAGE = ErrorMessage.ILLEGAL_READ_BRIDGE_SIZE.getTagMessage();

    public IllegalReadBridgeSizeException() {
        super(MESSAGE);
    }
}
