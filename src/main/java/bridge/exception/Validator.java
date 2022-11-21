package bridge.exception;

import bridge.domain.BrideLength;
import bridge.domain.Moving;

public class Validator {

    public static void validBridgeLength(int bridgeLength) {
        if (bridgeLength < BrideLength.MIN.getSize() || bridgeLength > BrideLength.MAX.getSize()) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_LENGTH.getMessage());
        }
    }

    public static Moving validMoving(String movingExpression) {
        if (Moving.findByExpression(movingExpression).isPresent()) {
            return Moving.findByExpression(movingExpression).get();
        }
        throw new IllegalArgumentException(Error.WRONG_MOVING.getMessage());
    }
}