package bridge.validator;

public class InputRetryOrExitValidator {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    private static final String RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작/종료 여부 입력 시 " + RETRY + ", " + QUIT + "만 입력 가능합니다.";

    public static void validateRetryOrExitCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(RETRY_OR_EXIT_COMMAND_ERROR_MESSAGE);
        }
    }

}
