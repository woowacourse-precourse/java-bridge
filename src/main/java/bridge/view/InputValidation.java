package bridge.view;

import bridge.model.Direction;
import bridge.model.RetryCommand;
import bridge.util.ExceptionMessage;

public class InputValidation {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static int convertToNumber(String sizeInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(sizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.CANNOT_CONVERT_TO_NUMBER);
        }
    }

    public static void isValidBridgeSize(int size) throws IllegalArgumentException {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    public static void isValidDirection(String directionInput) throws IllegalArgumentException {
        if (!Direction.equals(directionInput, Direction.UP)
                && !Direction.equals(directionInput, Direction.DOWN)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.INVALID_DIRECTION);
        }
    }

    public static void isValidGameCommand(String commandInput) throws IllegalArgumentException {
        if (!RetryCommand.equals(commandInput, RetryCommand.RETRY)
                && !RetryCommand.equals(commandInput, RetryCommand.QUIT)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.INVALID_GAME_COMMAND);
        }
    }
}
