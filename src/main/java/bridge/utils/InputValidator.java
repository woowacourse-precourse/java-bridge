package bridge.utils;

import bridge.constant.Error;
import bridge.constant.Game;

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
        if((size < Game.BRIDGE_SIZE_MIN) || (size > Game.BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
        return size;
    }
}
