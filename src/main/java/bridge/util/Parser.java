package bridge.util;

import bridge.exception.IllegalArgument;

public class Parser {

    public int parseBridgeSize(String bridgeSizeInput) {
        if (IllegalArgument.isNotNumber(bridgeSizeInput) || IllegalArgument.isNotInBridgeSizeRange(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR);
        }
        return Integer.parseInt(bridgeSizeInput);
    }

    public String parseMoving(String moving) {
        if (IllegalArgument.isIncorrectMoving(moving)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_MOVING_ERROR);
        }
        return moving;
    }
}
