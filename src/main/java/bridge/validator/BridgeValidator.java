package bridge.validator;

import bridge.exception.BridgeException;

import java.util.List;

public class BridgeValidator {

    private static final int INDEX_ZERO = 0;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    public static int checkBridgeSizeValid(final int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || BRIDGE_MAX_SIZE < bridgeSize) {
            BridgeException.invalidBridgeSize();
        }
        return bridgeSize;
    }

    public static int checkBridgeIndexValid(final int size, final int index) {
        if (size <= index) {
            BridgeException.invalidBridgeIndex(size, index);
        }
        return index;
    }
}
