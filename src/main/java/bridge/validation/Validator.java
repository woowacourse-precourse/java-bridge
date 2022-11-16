package bridge.validation;

import bridge.type.NumberType;

public class Validator {

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isCorrectBoundary(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (bridgeSize < NumberType.BRIDGE_MIN_LENGTH.getNumber() || bridgeSize > NumberType.BRIDGE_MAX_LENGTH.getNumber()) {
            return false;
        }
        return true;
    }
}
