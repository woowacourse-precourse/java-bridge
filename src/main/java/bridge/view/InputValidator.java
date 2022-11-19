package bridge.view;

public class InputValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String NOT_DIGIT = "정수형의 숫자가 아닙니다.";
    private static final String INVALID_BRIDGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static int changeInputToInt(String input) {
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    public static void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(getErrorMessage(INVALID_BRIDGE_SIZE));
        }
    }

    private static void validateIsNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(getErrorMessage(NOT_DIGIT));
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static String getErrorMessage(String message) {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
