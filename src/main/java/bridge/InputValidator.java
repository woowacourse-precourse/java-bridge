package bridge;

public class InputValidator {
    private static final String ERROR_FOR_LENGTH_OF_BRIDGE = "[ERROR] 다리의 길이는 3이상 20이하의 숫자만 가능합니다.";
    private static final String ERROR_FOR_UP_OR_DOWN = "[ERROR] 위: \"U\", 아래: \"D\"로만 가능합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    public static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static void validateRange(int input) {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException(ERROR_FOR_LENGTH_OF_BRIDGE);
        }
    }

    public static void validateUpOrDown(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException(ERROR_FOR_UP_OR_DOWN);
        }
    }
}
