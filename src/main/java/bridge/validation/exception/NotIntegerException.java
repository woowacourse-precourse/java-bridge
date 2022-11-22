package bridge.validation.exception;

import static bridge.validation.Message.ENTER_INTEGER;
import static bridge.validation.Message.ERROR_MESSAGE;

public class NotIntegerException extends IllegalArgumentException {
    public NotIntegerException() {
        super(ERROR_MESSAGE.getMessage() + ENTER_INTEGER.getMessage());
    }
}
