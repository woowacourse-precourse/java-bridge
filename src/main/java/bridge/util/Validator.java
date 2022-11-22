package bridge.util;

import static bridge.util.Constant.*;

public class Validator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validateNumericInputType(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ALLOW_ONLY_NUM);
        }
    }

    public static void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ALLOW_3_TO_20);
        }
    }

    public static void validateMovingInput(String input) {
        if (!input.equals(UPLOCATION) && !input.equals(DOWNLOCATION)) {
            throw new IllegalArgumentException(ALLOW_U_OR_D);
        }
    }

    public static void validateGameCommandInput(String input) {
        if (!input.equals(RESTART) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(ALLOW_R_OR_Q);
        }
    }

    public static void validateLocationNum(int locationNum) {
        if (locationNum != DOWN_NUMBER && locationNum != UP_NUMBER) {
            throw new IllegalArgumentException(ALLOW_0_OR_1);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY) {
            throw new IllegalArgumentException(NOT_ALLOW_UNDER_1);
        }
    }
}
