package Utils;

import bridge.EnumCollections.ExceptionType;

public class ValidateUtils {
    public static void isValidateLength(String input) {
        if (!InputUtils.isDigit(input) || !InputUtils.isValidRangeDigit(input)) {
            throw new IllegalArgumentException(ExceptionType.BRIDGE_LENGTH_ERROR.getErrorMessage());
        }
    }

    public static void isValidatePosition(String input) {
        if (!InputUtils.isValidBridgePosition(input)) {
            throw new IllegalArgumentException(ExceptionType.BRIDGE_POSITION_ERROR.getErrorMessage());
        }
    }

    public static void isValidateGameRestart(String input) {
        if (!InputUtils.isValidGameRestartInput(input)) {
            throw new IllegalArgumentException(ExceptionType.BRIDGE_RESTART_ERROR.getErrorMessage());
        }
    }
}
