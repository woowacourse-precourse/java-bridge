package bridge.validator;

import bridge.exception.BridgeException;

public class BridgeValidator {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    public static int checkBridgeSizeNotInvalid(final int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
            BridgeException.invalidBridgeSize();
        }
        return bridgeSize;
    }
}
