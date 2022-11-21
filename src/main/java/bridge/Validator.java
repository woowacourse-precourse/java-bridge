package bridge;

public class Validator {
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20이하의 숫자여야 합니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String NOT_UP_OR_DOWN_ERROR_MESSAGE = "[ERROR] U 또는 D만 입력해주세요.";
    private static final String NOT_RETRY_OR_QUIT_ERROR_MESSAGE = "[ERROR] R 또는 Q만 입력해주세요.";

    public static void validateBridgeSize(int bridgeSize) {
        if ((bridgeSize < 3) || (bridgeSize > 20)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static int convertNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void checkUpOrDown(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(NOT_UP_OR_DOWN_ERROR_MESSAGE);
        }
    }

    public static void checkRetryOrQuit(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(NOT_RETRY_OR_QUIT_ERROR_MESSAGE);
        }
    }
}
