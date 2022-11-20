package bridge.view;

import bridge.exception.view.BridgeSizeRangeException;

public class InputValidator {
    private static final int BRIDGE_LENGTH_MIN = 3;
    private static final int BRIDGE_LENGTH_MAX = 20;

    public void validateBridgeSizeRange(int size) {
        if (size < BRIDGE_LENGTH_MIN || size > BRIDGE_LENGTH_MAX) {
            throw new BridgeSizeRangeException(BRIDGE_LENGTH_MIN, BRIDGE_LENGTH_MAX);
        }
    }
}
