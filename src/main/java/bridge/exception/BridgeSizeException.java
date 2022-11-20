package bridge.exception;

public class BridgeSizeException {

    private static final String NUMERIC_REGEX = "[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 입력은 0보다 큰 숫자여야 합니다.";
    private static final String WRONG_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static void validate(String input) {
        CommonInputException.validate(input);
        checkNumeric(input);
        checkRange(Integer.parseInt(input));
    }

    private static void checkNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void checkRange(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR_MESSAGE);
        }
    }
}
