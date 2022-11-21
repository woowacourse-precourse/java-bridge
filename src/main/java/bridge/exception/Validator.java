package bridge.exception;

import bridge.domain.BridgeLength;
import bridge.domain.Moving;

public class Validator {

    public static void validBridgeLength(int bridgeLength) {
        if (bridgeLength < BridgeLength.MIN.getSize() || bridgeLength > BridgeLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }

    public static void validMoving(String movingExpression) {
        if (Moving.findByExpression(movingExpression).isEmpty()) {
            throw new IllegalArgumentException(Error.WRONG_MOVING.getMessage());
        }
    }
}