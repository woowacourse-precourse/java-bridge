package bridge.exception;

import bridge.constant.ErrorMessage;

public class IllegalRetryCommandException extends IllegalArgumentException {
    public IllegalRetryCommandException() {
        super(ErrorMessage.RETRY_COMMAND.getMessage());
    }
}
