package bridge.validator;

import bridge.exception.MovingDirectionFormatException;

public class MovingDirectionValidator {
    private final static String DIRECTION_FORMAT = "[U/D]";

    public static void validateDirection(String direction) {
        if (!direction.matches(DIRECTION_FORMAT)) {
            throw new MovingDirectionFormatException();
        }
    }
}
