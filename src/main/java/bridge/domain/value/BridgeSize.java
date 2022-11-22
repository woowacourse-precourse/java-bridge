package bridge.domain.value;

import static bridge.utils.ErrorMessages.ERROR_NOT_INTEGER;
import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;

public class BridgeSize {
    private static final int SIZE_MIN_RANGE = 3;
    private static final int SIZE_MAX_RANGE = 20;
    private final int bridgeSize;

    public BridgeSize(String input) {
        validate(input);
        this.bridgeSize = Integer.parseInt(input);
    }

    public void validate(String bridgeSize) {
        validateInteger(bridgeSize);
        validateBridgeSize(bridgeSize);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void validateBridgeSize(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < SIZE_MIN_RANGE || bridgeSize > SIZE_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public int getSize() {
        return bridgeSize;
    }
}
