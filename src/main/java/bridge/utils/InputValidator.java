package bridge.utils;

import bridge.constant.BridgeStatus;
import bridge.constant.Error;
import bridge.constant.Game;

public class InputValidator {
    public int isBridgeSizeNumeric(String input) {
        try {
            int bridgeSize = Integer.parseInt(input);
            return isSizeinRange(bridgeSize);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
    }
    private int isSizeinRange(int size) {
        if((size < Game.BRIDGE_SIZE_MIN) || (size > Game.BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_VALID.getError());
        }
        return size;
    }
    public void isMovementValid(String movement) {
        if (!movement.equals(BridgeStatus.UP.getStatus()) && !movement.equals(BridgeStatus.DOWN.getStatus())) {
            throw new IllegalArgumentException(Error.MOVEMENT_VALID.getError());
        }
    }
    public void isRetryValid(String retry) {
        if(!retry.equals(Game.RETRY_GAME) && !retry.equals(Game.QUIT_GAME)) {
            throw new IllegalArgumentException(Error.RETRY_VALID.getError());
        }
    }
}
