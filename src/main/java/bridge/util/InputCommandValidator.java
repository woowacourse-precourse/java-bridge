package bridge.util;

public class InputCommandValidator {
    private static final String ERROR_MOVE_COMMAND = "[ERROR] 종료는 Q, 재시작은 R로 입력 가능합니다.";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static void validator(String input) {
        validateCommand(input);
    }

    private static void validateCommand(String input) {
        if (!RESTART.equals(input) && !QUIT.equals(input)) {
            throw new IllegalArgumentException(ERROR_MOVE_COMMAND);
        }
    }
}
