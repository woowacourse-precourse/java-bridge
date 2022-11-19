package bridge.validator;

import bridge.exception.ExceptionType;

public class Validator {
    public static String validateGameCommand(String input) {
        if (!"Q".equals(input) && !"R".equals(input)) {
            throw new IllegalArgumentException(ExceptionType.GAME_COMMAND_EXCEPTION.getErrorMessage());
        }
        return input;
    }

    public static String validateMoving(String input) {
        if (!"U".equals(input) && !"D".equals(input)) {
            throw new IllegalArgumentException(ExceptionType.MOVE_TYPE_EXCEPTION.getErrorMessage());
        }
        return input;
    }

    public static int validateBridgeSize(String input) {
        int bridgeSize = validateIntegerType(input);
        validateRange(bridgeSize);
        return bridgeSize;
    }

    private static int validateIntegerType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.INTEGER_TYPE_EXCEPTION.getErrorMessage());
        }
    }

    private static int validateRange(int num) {
        if (num < 3 || num > 20) {
            throw new IllegalArgumentException(ExceptionType.BRIDGE_RANGE_EXCEPTION.getErrorMessage());
        }
        return num;
    }
}
