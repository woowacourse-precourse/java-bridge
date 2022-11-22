package bridge.validation.exception;

import static bridge.validation.Message.ERROR_MESSAGE;
import static bridge.validation.Message.OR_LESS;
import static bridge.validation.Message.OR_OVER;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(ERROR_MESSAGE.getMessage() + 3
                + OR_OVER.getMessage()
                + 20
                + OR_LESS.getMessage());
    }
}
