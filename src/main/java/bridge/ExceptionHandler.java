package bridge;

import bridge.data.Error;

public class ExceptionHandler {

    private static final int START_NUMBER = 3;
    private static final int END_NUMBER = 20;

    public static void checkNullInput(String input) throws IllegalArgumentException {
        if (input.length() <= 0) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }
    }

    public static void checkIsNumber(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }

    public static void checkOutOfRange(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < START_NUMBER || bridgeSize > END_NUMBER) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }

    public static void checkIsCharacter(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException(Error.NOT_CHARACTER.getMessage());
        }
    }
}
