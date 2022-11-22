package bridge.domain;

import static bridge.utils.Constant.BRIDGE_MAX_SIZE;
import static bridge.utils.Constant.BRIDGE_MIN_SIZE;
import static bridge.utils.Constant.WRONG_BRIDGE_SIZE_MESSAGE;

import bridge.utils.Converter;

public class BridgeSize {

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        int size = Converter.parseToInteger(bridgeSize);
        validBridgeSize(size);
        this.bridgeSize = size;
    }

    private void validBridgeSize(int size) {
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE_MESSAGE);
        }
    }

    public int getLength() {
        return bridgeSize;
    }
}
