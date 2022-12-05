package bridge.domain;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;

public class BridgeSize {
    private static final int SIZE_MIN_RANGE = 3;
    private static final int SIZE_MAX_RANGE = 20;
    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public void validate(int bridgeSize) {
        validateBridgeSize(bridgeSize);
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < SIZE_MIN_RANGE || bridgeSize > SIZE_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public int getSize() {
        return bridgeSize;
    }
}
