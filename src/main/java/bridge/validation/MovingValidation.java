package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class MovingValidation {
    private ErrorMessage message;

    public void isNull(String moving) {
        if (moving.isEmpty()) {
            message = ErrorMessage.valueOf("MOVING_NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String moving) {
    }

    public void isUpperCaseUD(String moving) {
    }
}