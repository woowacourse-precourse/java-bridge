package bridge.validators;

import bridge.messages.ErrorMessage;

public class InputValidator {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static void validateBridgeSize(String bridgeSizeInput) {
        if (!isNumeric(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (isOutOfRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public static boolean validateMoveDirection(String moveDirectionInput) {
        return moveDirectionInput.equals("U") || moveDirectionInput.equals("D");
    }

    static boolean isNumeric(String input) {
        if (input.charAt(0) == '0') {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    static boolean isOutOfRange(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            return true;
        }
        return false;
    }
}
