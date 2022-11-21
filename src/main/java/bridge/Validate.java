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


}
