package bridge.utils;

import bridge.constant.Error;

public class InputValidator {

    public static int isBridgeSizeNumeric(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
    }
}
