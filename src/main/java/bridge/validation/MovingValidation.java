package bridge.validation;

import bridge.validation.enums.ErrorMessage;

public class MovingValidation {
    private ErrorMessage message;

    public MovingValidation() {
    }

    public void throwError(String message) {
        throw new IllegalArgumentException(message);
    }

    public void isNull(String moving) {
        if (moving.isEmpty()) {
            message = ErrorMessage.valueOf("MOVING_NULL_EXCEPTION");
            throw new NullPointerException(message.getMessage());
        }
    }

    public void isBlank(String moving) {
        if (moving.isBlank() && moving.length() != 0) {
            message = ErrorMessage.valueOf("MOVING_BLANK_EXCEPTION");
            throwError(message.getMessage());
        }
    }

    public void isUpperCaseUD(String moving) {
    }
}