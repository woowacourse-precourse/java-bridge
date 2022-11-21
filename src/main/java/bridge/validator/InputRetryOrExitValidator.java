package bridge.validator;

public class InputRetryOrExitValidator {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    private static final String RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE = RETRY + "," + QUIT + "만 입력할 수 있습니다.";

    public static void validateRetryOrExitCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE);
        }
    }

}
