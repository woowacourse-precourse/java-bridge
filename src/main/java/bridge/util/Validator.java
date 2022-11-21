package bridge.util;

public class Validator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validateNumericInputType(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Constant.ALLOW_ONLY_NUM);
        }
    }

    public static void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Constant.ALLOW_3_TO_20);
        }
    }

    public static void validateMovingInput(String input) {
        if (!input.equals(Constant.UP) && !input.equals(Constant.DOWN)) {
            throw new IllegalArgumentException(Constant.ALLOW_U_OR_D);
        }
    }

    public static void validateGameCommandInput(String input) {
        if (!input.equals(Constant.RESTART) && !input.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(Constant.ALLOW_R_OR_Q);
        }
    }

    public static void validateLocationNum(int locationNum) {
        if (locationNum != Constant.DOWN_NUMBER && locationNum != Constant.UP_NUMBER) {
            throw new IllegalArgumentException(Constant.ALLOW_0_OR_1);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < Constant.MINIMUM_TRY) {
            throw new IllegalArgumentException(Constant.NOT_ALLOW_UNDER_1);
        }
    }
}
