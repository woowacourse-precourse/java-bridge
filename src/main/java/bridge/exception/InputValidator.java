package bridge.exception;

import bridge.data.Command;
import bridge.data.Error;
import bridge.data.Moving;

public class InputValidator {

    public static void validateBridgeLength(String length) {
        if (!isNumber(length) || length.isEmpty()) {
            throw new IllegalArgumentException(Error.INVALID_BRIDGE_LENGTH_TYPE_MESSAGE.getMessage());
        }
        int parsedNumber = Integer.parseInt(length);
        if ((parsedNumber < 3) || (parsedNumber > 20)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateCorrectMovingCommand(String moving) {
        if (!moving.equals(Moving.UP.getLabel()) && !moving.equals(Moving.DOWN.getLabel())) {
            throw new IllegalArgumentException(Error.INVALID_MOVING_COMMAND_MESSAGE.getMessage());
        }
    }

    public static void validateCorrectRetryCommand(String retry) {
        if (!retry.equals(Command.RETRY.getLabel()) && !retry.equals(Command.QUIT.getLabel())) {
            throw new IllegalArgumentException(Error.INVALID_RETRY_COMMAND_MESSAGE.getMessage());
        }
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
