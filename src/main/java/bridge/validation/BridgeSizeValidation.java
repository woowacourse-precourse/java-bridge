package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class BridgeSizeValidation {
    private ErrorMessage message;

    public BridgeSizeValidation() {
    }

    public void isNull(String bridgeSize) {
        if (bridgeSize.isEmpty()) {
            message = ErrorMessage.valueOf("NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String bridgeSize) {
    }

    public void isNumber(String bridgeSize) {
    }

    public void isCorrectRange(String bridgeSize) {
    }
}