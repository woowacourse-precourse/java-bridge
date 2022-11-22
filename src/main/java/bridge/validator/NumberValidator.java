package bridge;

public class NumberValidator {
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3~20 중의 숫자여야 합니다.";

    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static int validateRange(String input) {
        int number = validateNonNumeric(input);
        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        return number;
    }
}
