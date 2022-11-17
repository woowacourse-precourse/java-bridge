package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class BridgeSizeValidation {
    private ErrorMessage message;

    public BridgeSizeValidation() {
    }

    public void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public void isNull(String bridgeSize) {
        if (bridgeSize.isEmpty()) {
            message = ErrorMessage.valueOf("NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String bridgeSize) {
        if (bridgeSize.isBlank() && bridgeSize.length() != 0) {
            message = ErrorMessage.valueOf("BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isNumber(String bridgeSize) {
    }

    public void isCorrectRange(String bridgeSize) {
    }
}