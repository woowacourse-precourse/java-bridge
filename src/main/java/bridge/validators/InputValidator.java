package bridge.validators;

import bridge.messages.ErrorMessage;

import java.util.Arrays;

public class InputValidator {

    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final String[] RETRY = { "R", "r" };
    private static final String[] QUIT = { "Q", "q" };
    private static final String[] UP = { "U", "u" };
    private static final String[] DOWN = { "D", "d" };

    public static void validateBridgeSize(String bridgeSizeInput) {
        if (!isNumeric(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (isOutOfRange(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
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

    public static void validateMoveDirection(String moveDirectionInput) {
        if (!(Arrays.asList(UP).contains(moveDirectionInput)
                || Arrays.asList(DOWN).contains(moveDirectionInput))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_DIRECTION.getMessage());
        }
    }

    public static void validateRetryInput(String retryInput) {
        if (!(Arrays.asList(RETRY).contains(retryInput)
                || Arrays.asList(QUIT).contains(retryInput))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_INPUT.getMessage());
        }
    }
}
