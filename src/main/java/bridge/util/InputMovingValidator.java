package bridge.util;

public class InputMovingValidator {
    private static final String ERROR_MOVE_COMMAND = "[ERROR] 이동은 U 또는 D로만 입력 가능합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static void validator(String input) {
        validateMove(input);
    }

    private static void validateMove(String input) {
        if (!UP.equals(input) && !DOWN.equals(input)) {
            throw new IllegalArgumentException(ERROR_MOVE_COMMAND);
        }
    }
}
