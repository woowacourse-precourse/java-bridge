package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
import bridge.domain.constants.ErrorCode;

public class BridgeSize {

    private final int size;

    private BridgeSize(int size) {
        validSize(size);
        this.size = size;
    }

    public static BridgeSize from(int size) {
        return new BridgeSize(size);
    }

    public int getValue() {
        return size;
    }

    private void validSize(int size) {
        if (size < BridgeConstants.BRIDGE_SIZE_START || size > BridgeConstants.BRIDGE_SIZE_END) {
            throw ErrorCode.SIZE_NOT_IN_RANGE.getException();
        }
    }
}
