package bridge.validator;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class MovingValidator {

    public static void validateMoving(String input) {
        if (!input.equals(Constant.UP) && !input.equals(Constant.DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MOVING_VALUE);
        }
    }
}
