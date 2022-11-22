package bridge.valid;

import bridge.exception.BridgeGameError;

public class BridgeValidator {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private BridgeValidator() {
    }

    public static void validateSize(int size) {
        if (isOutRange(size)) {
            throw new IllegalArgumentException(BridgeGameError.BRIDGE_SIZE_NOT_INCLUDE_RANGE.getErrorMessage());
        }
    }

    private static boolean isOutRange(int size) {
        return (size < MIN_LENGTH || size > MAX_LENGTH);
    }
}
