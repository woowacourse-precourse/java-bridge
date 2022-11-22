package bridge.validator;

import bridge.Moving;

public class MovingValidator {

    public static void validateMoving(String moving) {
        Moving.of(moving);
    }
}
