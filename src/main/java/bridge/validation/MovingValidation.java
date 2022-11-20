package bridge.validation;

import bridge.validation.enums.ErrorMessage;
import bridge.validation.enums.RegEx;
import java.util.regex.Pattern;

public class MovingValidation {
    private ErrorMessage message;
    private RegEx regEx;

    public MovingValidation() {
    }

    public void isValidate(String moving) {
        isNull(moving);
        isBlank(moving);
        isUpperCaseUD(moving);
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
        regEx = RegEx.valueOf("MOVING_TYPE_REG_EX");
        if (!Pattern.matches(regEx.getRegEx(), moving)) {
            message = ErrorMessage.valueOf("MOVING_TYPE_EXCEPTION");
            throwError(message.getMessage());
        }
    }
}