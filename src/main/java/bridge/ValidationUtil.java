package bridge;

import bridge.enums.ConstVariable;
import bridge.enums.InputKey;

public class ValidationUtil {

    public static boolean isValidBridgeLength(int value) {
        return value >= ConstVariable.MIN_BRIDGE_LENGTH.getValue()
                && value <= ConstVariable.MAX_BRIDGE_LENGTH.getValue();
    }

    public static boolean isUpOrDown(String input) {
        return input.equals(InputKey.U.getValue()) ||
                input.equals(InputKey.D.getValue());
    }

    public static boolean isRetryOrQuit(String input) {
        return input.equals(InputKey.R.getValue()) ||
                input.equals(InputKey.Q.getValue());
    }
}
