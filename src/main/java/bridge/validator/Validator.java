package bridge.validator;

import bridge.exception.ExceptionType;

public class Validator {
    public static void validateMoving(String input) {
        if (!"U".equals(input) && !"D".equals(input)) {
            throw new IllegalArgumentException(ExceptionType.MOVE_TYPE_EXCEPTION.getErrorMessage());
        }
    }

    public static void validateBridgeSize(String input) {
        validateIntegerType(input);
        validateRange(Integer.parseInt(input));
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.INTEGER_TYPE_EXCEPTION.getErrorMessage());
        }
    }

    private static void validateRange(int num) {
        if (num < 3 || num > 20) {
            throw new IllegalArgumentException(ExceptionType.BRIDGE_RANGE_EXCEPTION.getErrorMessage());
        }
    }
}
