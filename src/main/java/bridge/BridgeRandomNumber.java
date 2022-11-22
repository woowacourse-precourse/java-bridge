package bridge;

import bridge.exception.BridgeError;
import bridge.exception.ErrorException;
import bridge.utils.Constants;

public class BridgeRandomNumber {
    private final int bridgeRandomNumber;

    public BridgeRandomNumber(int bridgeRandomNumber) {
        this.bridgeRandomNumber = bridgeRandomNumber;
        if (!checkInvalidRandomNumber()) {
            throw new ErrorException(BridgeError.INVALID_RANDOM_NUMBER);
        }
    }

    private boolean checkInvalidRandomNumber() {
        return bridgeRandomNumber == Constants.RANDOM_LOWER_INCLUSIVE || bridgeRandomNumber == Constants.RANDOM_UPPER_INCLUSIVE;
    }
}
