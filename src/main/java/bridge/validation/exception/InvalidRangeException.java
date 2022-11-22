package bridge.validation.exception;

import static bridge.Bridge.MAX_BRIDGE_SIZE;
import static bridge.Bridge.MIN_BRIDGE_SIZE;
import static bridge.validation.Message.ERROR_MESSAGE;
import static bridge.validation.Message.OR_LESS;
import static bridge.validation.Message.OR_OVER;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(ERROR_MESSAGE.getMessage() + MIN_BRIDGE_SIZE
                + OR_OVER.getMessage()
                + MAX_BRIDGE_SIZE
                + OR_LESS.getMessage());
    }
}
