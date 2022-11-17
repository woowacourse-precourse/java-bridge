package bridge;

public class Validation {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;

    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String NOT_NUMBER_TYPE_MESSAGE = "다리 길이는 숫자만 입력 가능합니다.";
    private final static String INVALID_NUMBER_RANGE_MESSAGE = "다리 길이는 " + MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";

    private static void isNumberType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_TYPE_MESSAGE);
        }
    }

    private static void isValidNumberRange(int number) {
        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void validateBridgeSizeInput(String inputBrideSize) {
        isNumberType(inputBrideSize);
        isValidNumberRange(Integer.parseInt(inputBrideSize));
    }
}
