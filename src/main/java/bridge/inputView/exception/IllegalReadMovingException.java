package bridge.inputView.exception;

import bridge.common.ErrorMessage;

public class IllegalReadMovingException extends IllegalArgumentException {
    private static final String MESSAGE = ErrorMessage.ILLEGAL_READ_MOVING.getTagMessage();

    public IllegalReadMovingException() {
        super(MESSAGE);
    }
}
