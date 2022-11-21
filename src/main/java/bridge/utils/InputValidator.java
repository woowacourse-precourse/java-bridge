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
    private static int isSizeinRange(int size) {
        if((size < Game.BRIDGE_SIZE_MIN) || (size > Game.BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
        return size;
    }
    public void isMovementValid(String movement) {
        if (!movement.equals(Game.BRIDGE_GENERATE_DOWN) && !movement.equals(Game.BRIDGE_GENERATE_UP)) {
            throw new IllegalArgumentException(Error.MOVEMENT_VALID.getError());
        }
    }
}
