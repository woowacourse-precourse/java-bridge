package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;

public class BridgeSize {
    private static final int MIN_BRIDE_SIZE = 3;
    private static final int MAX_BRIDE_SIZE = 20;

    private final String bridgeSizeInput;
    private final int bridgeSize;

    public BridgeSize(String bridgeSizeInput) {
        this.bridgeSizeInput = bridgeSizeInput;
        isNotNumeric();
        this.bridgeSize = Integer.parseInt(bridgeSizeInput);
        checkInvalidRange();
    }

    private void isNotNumeric() {
        if (!bridgeSizeInput.chars().allMatch(Character::isDigit)) {
            throw new ErrorException(BridgeError.IS_NOT_NUMERIC);
        }
    }

    private void checkInvalidRange() {
        if ((MIN_BRIDE_SIZE > bridgeSize) || (MAX_BRIDE_SIZE < bridgeSize)) {
            throw new ErrorException(BridgeError.INVALID_RANGE);
        }
    }
}
