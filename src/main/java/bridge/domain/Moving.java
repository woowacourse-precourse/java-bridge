package bridge.domain;

import bridge.constant.ErrorMessage;

public class Moving {
    private static final String MOVING_UP_CHARACTER = "U";
    private static final String MOVING_DOWN_CHARACTER = "D";

    private final String value;

    public Moving(String moving){
        validateMoving(moving);
        this.value = moving;
    }

    private void validateMoving(String moving){
        if (MOVING_UP_CHARACTER != moving || MOVING_DOWN_CHARACTER != moving){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MOVING_CHARACTER.getMessage());
        }
    }

    public static String getMovingUpCharacter() {
        return MOVING_UP_CHARACTER;
    }

    public static String getMovingDownCharacter() {
        return MOVING_DOWN_CHARACTER;
    }

    public String getValue() {
        return value;
    }
}
