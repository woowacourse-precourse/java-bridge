package bridge.exception;

import bridge.domain.BrideLength;
import bridge.domain.BridgeSpace;
import java.util.Objects;

public class Validator {

    public static void validBridgeLength(int bridgeLength) {
        if (bridgeLength < BrideLength.MIN.getSize() || bridgeLength > BrideLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }

    public static void validBridgeSpaceType(String input) {
        if (!Objects.equals(input, BridgeSpace.DOWN.getType()) &&
                    !Objects.equals(input, BridgeSpace.UP.getType())) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_SPACE_TYPE.getMessage());
        }
    }
}