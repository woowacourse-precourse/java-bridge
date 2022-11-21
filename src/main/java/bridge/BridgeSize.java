package bridge;

import bridge.utils.Converter;
import bridge.utils.Validator;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(String userBridgeSize) {
        Validator.validateNumber(userBridgeSize);
        int tempBridgeSize = Converter.convertToNumber(userBridgeSize);
        Validator.validateRange(tempBridgeSize);
        bridgeSize = tempBridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
