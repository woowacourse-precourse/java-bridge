package bridge.util;

import bridge.enums.ConstVariable;
import bridge.enums.ErrorMessage;
import bridge.enums.InputKey;

public class ValidationUtil {

    public static void isValidBridgeLength(int value) {
        if (value < ConstVariable.MIN_BRIDGE_LENGTH.getValue()
                || value > ConstVariable.MAX_BRIDGE_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getValue());
        }
    }

    public static void isUpOrDown(String input) {
        if (!input.equals(InputKey.U.getValue()) &&
                !input.equals(InputKey.D.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!input.equals(InputKey.R.getValue()) &&
                !input.equals(InputKey.Q.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getValue());
        }
    }
}
