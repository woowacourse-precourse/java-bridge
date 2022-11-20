package bridge.domain;

import static bridge.utils.Constant.BRIDGE_MIN_SIZE;
import static bridge.utils.Constant.LESS_THAN_MIN_SIZE_MESSAGE;

import bridge.utils.Converter;

public class BridgeSize {

    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        int size = Converter.parseToInteger(bridgeSize);
        validGreaterThanZero(size);
        this.bridgeSize = size;
    }

    private void validGreaterThanZero(int size) {
        if (size < BRIDGE_MIN_SIZE) {
            throw new IllegalArgumentException(LESS_THAN_MIN_SIZE_MESSAGE);
        }
    }

    public int getLength() {
        return bridgeSize;
    }
}
