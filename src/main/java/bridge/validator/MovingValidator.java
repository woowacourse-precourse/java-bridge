package bridge.validator;

import bridge.common.ErrorCode;

public class MovingValidator {
    public static final String MOVING_REGEX = "^[DU]{1}$";

    public static String validate(String input) {
        if (!input.matches(MOVING_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MOVING.getMessage());
        }
        return input;
    }
}
