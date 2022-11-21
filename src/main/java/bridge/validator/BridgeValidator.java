package bridge.validator;

import bridge.exception.BridgeException;


public class BridgeValidator {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final int INDEX_ZERO = 0;

    public static int checkBridgeSizeValid(final int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
            BridgeException.invalidBridgeSize();
        }
        return bridgeSize;
    }

    public static int checkBridgeIndexValid(final int size, final int index) {
        if (size <= index || index < INDEX_ZERO) {
            BridgeException.invalidBridgeIndex(size, index);
        }
        return index;
    }
}
