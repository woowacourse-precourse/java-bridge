package bridge.utils.validator;

import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;

public class MovingValidator {
    private static final String UP_SIDE_MOVING = "U";
    private static final String DOWN_SIDE_MOVING = "D";

    private MovingValidator() {
    }

    public static void validate(String moving) {
        validateMoving(moving);
    }

    private static void validateMoving(String moving) {
        if (!(moving.equals(UP_SIDE_MOVING) || moving.equals(DOWN_SIDE_MOVING))) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVING);
        }
    }
}
