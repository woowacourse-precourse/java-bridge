package bridge.util;

public class InputSizeValidator {
    private static final String ERROR_INPUT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 %d이상 %d이하로 입력 가능합니다.";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validator(String input) {
        int size = convertInt(input);
        validateBridgeRange(size);
    }

    private static int convertInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_INT);
        }
    }

    private static void validateBridgeRange(int size) {
        if (MAX_BRIDGE_SIZE < size || size < MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException(String.format(ERROR_BRIDGE_SIZE, MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE));
        }
    }
}
