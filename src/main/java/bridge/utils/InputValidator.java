package bridge.utils;

import bridge.constant.Error;

public class InputValidator {
    public static int isBridgeSizeNumeric(String input) {
        try {
            int bridgeSize = Integer.parseInt(input);
            return isSizeinRange(bridgeSize);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
    }
    public static int isSizeinRange(int size) {
        if((size < MIN) || (size > MAX)) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
    }
}
