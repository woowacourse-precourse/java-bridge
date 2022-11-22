package bridge.domain;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;
import bridge.utils.Constants;

public class BridgeSize {
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
        if ((Constants.MIN_BRIDE_SIZE > bridgeSize) || (Constants.MAX_BRIDE_SIZE < bridgeSize)) {
            throw new ErrorException(BridgeError.INVALID_RANGE);
        }
    }
}
