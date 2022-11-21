package bridge.exception;

import bridge.domain.BrideLength;
import bridge.domain.BridgeSpace;

public class Validator {

    public static void validBridgeLength(int bridgeLength) {
        if (bridgeLength < BrideLength.MIN.getSize() || bridgeLength > BrideLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }

    public static void validBridgeSpaceType(String type) {
        if (BridgeSpace.findByType(type) == null) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_SPACE_TYPE.getMessage());
        }
    }
}