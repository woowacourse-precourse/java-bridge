package bridge;

import bridge.constant.Error;

public class Validate {

    private static final String error = Error.ERROR.getMessage();

    public static void checkBridgeSize(String length) {
        if (notNumeric(length)) {
            throw new IllegalArgumentException(error + Error.BRIDGE_SIZE_NOT_NUMERIC.getMessage());
        }
        if (notInRange(length)) {
            throw new IllegalArgumentException(error + Error.BRIDGE_SIZE_NOT_IN_RANGE.getMessage());
        }
    }

    public static boolean notNumeric(String length) {
        return !length.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean notInRange(String length) {
        return Integer.parseInt(length) < 3 || Integer.parseInt(length) > 20;
    }
    
    public static void checkMoveDirection(String direction) {
        if (invalidDirection(direction)) {
            throw new IllegalArgumentException(error + Error.MOVE_DIRECTION_INVALID.getMessage());
        }
    }

    public static boolean invalidDirection(String direction) {
        return !(direction.equals("U") || direction.equals("D"));
    }

}
