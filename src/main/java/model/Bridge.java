package model;

import util.ErrorMessage;

public class Bridge {
    private final int MIN_BRIDGE_SIZE=3;
    private final int MAX_BRIDGE_SIZE=20;

    private final int bridgeSize;

    public Bridge(int bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void validateBridgeSize(int bridgeSize){
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_BRIDGE_SIZE);
        }
    }
}
