package bridge.view;

public class InputValidator {

    private static final String NOT_NUMBER_INPUT_FOR_BRIDGE_LENGTH = "[ERROR] 다리 길이는 숫자만 입력하실 수 있습니다.";
    private static final String OUT_OF_RANGE_INPUT_FOR_BRIDGE_LENGTH = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NOT_FOLLOW_MOVING_INPUT_RULE = "[ERROR] 이동은 U 또는 D로만 입력할 수 있습니다.";
    private static final String NOT_FOLLOW_RETRY_INPUT_RULE = "[ERROR] 다시 시도 여부는 R 또는 Q로만 입력할 수 있습니다.";

    public static void validateLengthInput(String input) {
        String numberStringFormat = "\\d{1,2}";
        if (!input.matches(numberStringFormat)) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_FOR_BRIDGE_LENGTH);
        }

        int length = Integer.parseInt(input);
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE_INPUT_FOR_BRIDGE_LENGTH);
        }
    }

    public static void validateMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(NOT_FOLLOW_MOVING_INPUT_RULE);
        }
    }

    public static void validateRetryInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(NOT_FOLLOW_RETRY_INPUT_RULE);
        }
    }
}
