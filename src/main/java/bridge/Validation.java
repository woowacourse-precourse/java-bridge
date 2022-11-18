package bridge;

import bridge.util.Constant;
import bridge.util.ExceptionMessage;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void checkOnlyNumber(String inputSize) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ExceptionMessage.CANNOT_CONVERT_TO_NUMBER);
        }
    }

    public static void isValidBridgeSize(String inputSize) throws IllegalArgumentException {
        int size = Integer.parseInt(inputSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ExceptionMessage.BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    public static void isValidDirection(String inputDirection) throws IllegalArgumentException {
        if (!inputDirection.equals(Constant.UP) && !inputDirection.equals(Constant.DOWN)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ExceptionMessage.INVALID_DIRECTION);
        }
    }

    public static void isValidGameCommand(String inputCommand) throws IllegalArgumentException {
        if (!inputCommand.equals(Constant.RETRY) && !inputCommand.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ExceptionMessage.INVALID_GAME_COMMAND);
        }
    }
}
