package bridge.exception;

public class GameCommandException {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String WRONG_RETRY_ERROR_MESSAGE = "[ERROR] 재시도는 R, 종료는 Q로 입력해야 합니다.";

    public static void validate(String input) {
        CommonInputException.validate(input);
        checkRightInput(input);
    }

    private static void checkRightInput(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(WRONG_RETRY_ERROR_MESSAGE);
        }
    }
}
