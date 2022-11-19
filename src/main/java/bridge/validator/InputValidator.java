package bridge.validator;

public class InputValidator {

    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static final String UP = "U";
    public static final String DOWN = "D";

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    private static final String BRIDGE_SIZE_ERROR_MESSAGE = "다리 길이는 " + MINIMUM_BRIDGE_SIZE+ "부터 "+ MAXIMUM_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    private static final String MOVING_INPUT_ERROR_MESSAGE = UP + "," + DOWN + "만 입력할 수 있습니다.";
    private static final String RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE = RETRY + "," + QUIT + "만 입력할 수 있습니다.";

    public static void validateBridgeSize(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateMovingInput(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateRetryOrExitCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE);
        }
    }

}
