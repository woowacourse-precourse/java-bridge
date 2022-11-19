package bridge;

public class NumberValidator {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private final static String RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3~20 중의 숫자여야 합니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
