package bridge.util.validator;

import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.ErrorMessage.MOVING_SPACE_INPUT_ERROR;

public class MovingValidator {
    public static void validate(String input) {
        if (!input.equals(UPPER_SPACE.getValue()) && !input.equals(LOWER_SPACE.getValue())) {
            String errorMessage = String.format(MOVING_SPACE_INPUT_ERROR.getMessage(),
                    UPPER_SPACE.getValue(), LOWER_SPACE.getValue());
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
