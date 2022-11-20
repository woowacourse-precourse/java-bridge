package bridge.util;

import bridge.exception.IllegalArgument;

public class Parser {

    public int parseBridgeSize(String bridgeSizeInput) {
        if (IllegalArgument.isNotNumber(bridgeSizeInput) || IllegalArgument.isNotInBridgeSizeRange(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
        }
        return Integer.parseInt(bridgeSizeInput);
    }
}
