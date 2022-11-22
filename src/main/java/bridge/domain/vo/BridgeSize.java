package bridge.domain.vo;

import static bridge.enumeration.ErrorMessage.*;
import static java.lang.Integer.parseInt;

public class BridgeSize {

    private final int bridgeSize;

    public static BridgeSize recordBridgeSize(String bridgeSize) {
        return new BridgeSize(bridgeSize);
    }

    private BridgeSize(String bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return this.bridgeSize;
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        if (parseInt(bridgeSize) < 3 || parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }
}
