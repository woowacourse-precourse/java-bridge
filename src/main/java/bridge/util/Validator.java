package bridge.util;

import bridge.domain.game.MovingType;

import static bridge.util.Constants.*;

public class Validator {

    public static void validateBridgeLength(int length) {
        if (length < MIN_LENGTH_OF_BRIDGE || length > MAX_LENGTH_OF_BRIDGE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_OF_BRIDGE);
        }
    }

    public static void validateStringIsNumeric(String input) {
        if (!input.matches(REGULAR_EXPRESSION_FOR_NUM)) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC_VALUE);
        }
    }

    public static void validateMovingType(String input) {
        if (!MovingType.isContains(input)) {
            throw new IllegalArgumentException(INVALID_MOVING_TYPE);
        }
    }

    public static void validateStringIsEnglish(String input) {
        if (!input.matches(REGULAR_EXPRESSION_FOR_ENG)) {
            throw new IllegalArgumentException(IS_NOT_ENGLISH);
        }
    }

    public static void validateRestartOption(String input) {
        if (!input.equals(RESTART_OPTION) && !input.equals(QUIT_OPTION)) {
            throw new IllegalArgumentException(INVALID_RESTART_OPTION);
        }
    }

    public static boolean isNeedRestart(String input) {
        return input.equals(RESTART_OPTION);
    }
}

