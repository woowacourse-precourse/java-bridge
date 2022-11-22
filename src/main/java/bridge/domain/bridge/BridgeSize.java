package bridge.domain.bridge;

import static bridge.validate.BridgeValidation.validateBridgeSize;
import static bridge.validate.BridgeValidation.validateBridgeSizeInput;

public class BridgeSize {

    private final int size;

    public BridgeSize(int size) {
        validateBridgeSize(size);
        this.size = size;
    }

    public static BridgeSize makeBridgeSize(int length) {
        return new BridgeSize(length);
    }

    public static BridgeSize makeBridgeSize(String lengthString) {
        validateBridgeSizeInput(lengthString);
        return new BridgeSize(Integer.parseInt(lengthString));
    }

    public int value() {
        return size;
    }
}
