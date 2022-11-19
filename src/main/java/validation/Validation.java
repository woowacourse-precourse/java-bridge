package validation;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void ofBridgeSize(String input) {
        validateBridgeSizeRange(toInt(input));
    }

    private static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 숫자이어야 합니다.");
        }
    }

    private static void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 3 이상 20 이하의 숫자이어야 합니다.");
    }

}
