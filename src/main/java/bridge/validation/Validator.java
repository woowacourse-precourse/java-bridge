package bridge.validation;

import bridge.type.ErrorMessage;
import bridge.type.NumberType;

public class Validator {



    public void checkBridgeSize(String input) {
        isNumeric(input);
        isCorrectBoundary(input);
    }


    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NUMERIC.getMessage());
        }
    }

    public void isCorrectBoundary(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (bridgeSize < NumberType.BRIDGE_MIN_LENGTH.getNumber() || bridgeSize > NumberType.BRIDGE_MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_BOUNDARY.getMessage());
        }
    }
}
