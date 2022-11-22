package bridge;

import static bridge.constant.BridgeSize.MAX_BRIDGE_SIZE;
import static bridge.constant.BridgeSize.MIN_BRIDGE_SIZE;
import static bridge.constant.ExceptionName.BRIDGE_MAKER_SIZE_EXCEPTION;

public class BridgeMakerValidate {

    private final int bridgeSize;

    public BridgeMakerValidate(String bridgeSize) {
        this.bridgeSize = validateBridgeSize(bridgeSize);
    }

    private int validateBridgeSize(String bridgeSize) {
        int integerBridgeSize = validateBridgeSizeInteger(bridgeSize);
        validateBridgeSizeRange(integerBridgeSize);
        return integerBridgeSize;
    }

    private int validateBridgeSizeInteger(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_MAKER_SIZE_EXCEPTION);
        }
    }

    private void validateBridgeSizeRange(int integerBridgeSize) {
        if (integerBridgeSize < MIN_BRIDGE_SIZE || integerBridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_MAKER_SIZE_EXCEPTION);
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
