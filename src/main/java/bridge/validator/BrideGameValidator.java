package bridge.validator;

import bridge.exception.BridgeGameException;

public class BrideGameValidator {

    private static final int INDEX_ZERO = 0;

    public static int checkBridgeIndexValid(final int size, final int index) {
        if (size <= index || index < INDEX_ZERO) {
            BridgeGameException.invalidBridgeIndex(size, index);
        }
        return index;
    }
}
