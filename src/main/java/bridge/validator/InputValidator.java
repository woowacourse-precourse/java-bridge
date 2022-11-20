package bridge.validator;

import bridge.exception.ExceptionMessage;

public class InputValidator {
    public void validateBridgeSize(int size) {
        if(size < 3 || size > 20) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }
}
