package bridge.exception.input;

public class InputException {
    private static final String NUMERIC_PATTERN = "\\d+";
    private static final int UNDER_RANGE = 3;
    private static final int OVER_RANGE = 20;
    private static final String MOVING_INPUT_PATTERN = "^[UD]$";
    private static final String GAME_COMMAND_INPUT_PATTERN = "^[RQ]$";

    private static final String BLANK = "";

    private static boolean isNotProperInput(String userInput, String pattern) {
        return !userInput.matches(pattern);
    }

    public static void validateProperBridgeLength(String userInput) {
        if (isNotProperInput(userInput, NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("not proper letter");
        }
    }

    private static boolean isProperNumbers(String userInput) {
        int bridgeLength = Integer.parseInt(userInput);
        return (bridgeLength < UNDER_RANGE || bridgeLength > OVER_RANGE);
    }

    public static void validateProperNumbersRange(String userInput) {
        if (isProperNumbers(userInput)) {
            throw new IllegalArgumentException("not proper range");
        }
    }

    public static void checkBridgeLengthInput(String userInput) {
        validateProperBridgeLength(userInput);
        validateProperNumbersRange(userInput);
    }

    public static void validateMovingInput(String moving) {
        if (isNotProperInput(moving, MOVING_INPUT_PATTERN)) {
            throw new IllegalArgumentException("not proper moving input");
        }
    }

    public static void validateGameCommandInput(String gameCommand) {
        if (isNotProperInput(gameCommand, GAME_COMMAND_INPUT_PATTERN)) {
            throw new IllegalArgumentException("not proper game command input");
        }
    }

}
