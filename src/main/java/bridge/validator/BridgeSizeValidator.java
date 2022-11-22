package bridge.validator;

import bridge.ErrorMessage;

public class BridgeSizeValidator {

    private static final int MIN_BRIDGE_SIZE = 3;

    private static final int MAX_BRIDGE_SIZE = 20;

    private final int bridgeSize;

    public BridgeSizeValidator(final int bridgeSize) {
        validateSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void validateSize(final int bridgeSize) {
        if (isOutOfBound(bridgeSize)) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_BRIDGE_SIZE
            );
        }
    }

    private boolean isOutOfBound(final int bridgeSize) {
        return bridgeSize > MAX_BRIDGE_SIZE || bridgeSize < MIN_BRIDGE_SIZE;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
