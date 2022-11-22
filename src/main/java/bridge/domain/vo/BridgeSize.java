package bridge.domain.vo;

import static bridge.view.enumeration.ErrorMessage.*;
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
            throw new IllegalArgumentException(IS_NOT_NUMBER.getErrorMessage());
        }
        if (parseInt(bridgeSize) < 3 || parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_IS_NOT_IN_RANGE.getErrorMessage());
        }
    }
}
