package bridge.exception;

import bridge.domain.BrideLength;

public class Validator {

    public static void checkBridgeLength(int bridgeLength) {
        if (bridgeLength < BrideLength.MIN.getSize() || bridgeLength > BrideLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }
}