package bridge.valid;

import bridge.exception.BridgeGameError;

public class BridgeSizeLengthValidator {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private BridgeSizeLengthValidator() {
    }

    public static boolean validateSize(int size) {
        if (isOutRange(size)) {
            throw new IllegalArgumentException(BridgeGameError.BRIDGE_SIZE_NOT_INCLUDE_RANGE.getErrorMessage());
        }
        return true;
    }

    private static boolean isOutRange(int size) {
        return (size < MIN_LENGTH || size > MAX_LENGTH);
    }
}
