package bridge.domain.bridge;

import static bridge.validate.BridgeValidation.validateBridgeSize;

public class BridgeSize {

    private final int size;

    public BridgeSize(int size) {
        validateBridgeSize(size);
        this.size = size;
    }

    public static BridgeSize makeBridgeSize(int length) {
        return new BridgeSize(length);
    }

    public int value() {
        return size;
    }
}
