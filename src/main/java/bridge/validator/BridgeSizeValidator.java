package bridge.validator;

import bridge.exception.BridgeSizeOutOfRangeException;

public class BridgeSizeValidator {
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;

    public static void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_SIZE || bridgeSize > MAX_SIZE) {
            throw new BridgeSizeOutOfRangeException();
        }
    }
}
