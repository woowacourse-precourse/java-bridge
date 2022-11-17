package bridge.exception;

public class BridgeSizeException {
    private static final String NUMERIC_REGEX = "[0-9]+";
    public static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 입력은 숫자여야 합니다.";

    public static void validator(String input) {
        checkNumeric(input);
    }

    private static void checkNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
