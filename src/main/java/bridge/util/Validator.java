package bridge.util;

public class Validator {

    public static void validateNumberType(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_NOT_NUMBER_TYPE.getMessage());
        }
    }

    public static void validateUpDown(String input) {
        if (isNotUorD(input)) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_UP_OR_DOWN.getMessage());
        }
    }

    private static boolean isNotUorD(String input) {
        return !input.matches(
                Rules.PLATE_DOWN_PLATE_SYMBOL
                        + "|" + Rules.PLATE_UP_PLATE_SYMBOL);
    }

    public static void validateRetryQuit(String input) {
        if (isRorQ(input)) {
            throw new IllegalArgumentException(Errors.ERROR_GAME_RETRY_OR_QUIT.getMessage());
        }
    }

    private static boolean isRorQ(String input) {
        return !input.matches(
                Rules.GAME_RETRY
                        + "|" + Rules.GAME_QUIT);
    }

    public static void validateBridgeSize(int bridgeLength) {
        if (isOutOfBoundsLength(bridgeLength)) {
            throw new IllegalArgumentException(Errors.ERROR_BRIDGE_LENGTH.getMessage());
        }
    }

    private static boolean isOutOfBoundsLength(int bridgeLength) {
        return (bridgeLength < Rules.BRIDGE_MIN_LENGTH)
                || (bridgeLength > Rules.BRIDGE_MAX_LENGTH);
    }
}
