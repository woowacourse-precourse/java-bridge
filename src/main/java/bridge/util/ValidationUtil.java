package bridge.util;

import bridge.enums.ConstVariable;
import bridge.enums.ErrorMessage;
import bridge.enums.Key;

public class ValidationUtil {

    public static void isValidBridgeLength(String input) {
        int value = isDigit(input);

        if (ConstVariable.isLowerThanMinBridgeLength(value)
                || ConstVariable.isGreaterThanMaxBridgeLength(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getValue());
        }
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getValue(), e);
        }
    }

    public static void isUpOrDown(String input) {
        if (!Key.matchUp(input) && !Key.matchDown(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!Key.matchRetry(input) && !Key.matchQuit(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }
}
