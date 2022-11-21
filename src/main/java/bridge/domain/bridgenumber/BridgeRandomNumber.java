package bridge.domain.bridgenumber;

import bridge.exception.BrideError;
import bridge.exception.ErrorException;

public class BridgeRandomNumber {
    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;
    private final int bridgeRandomNumber;

    public BridgeRandomNumber(int bridgeRandomNumber) {
        this.bridgeRandomNumber = bridgeRandomNumber;
        if (!checkInvalidRandomNumber()) {
            throw new ErrorException(BrideError.INVALID_RANDOM_NUMBER);
        }
    }

    private boolean checkInvalidRandomNumber() {
        return bridgeRandomNumber == RANDOM_LOWER_INCLUSIVE || bridgeRandomNumber == RANDOM_UPPER_INCLUSIVE;
    }
}
