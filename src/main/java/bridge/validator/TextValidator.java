package bridge.validator;

public class TextValidator {
    private final static String MOVE_WAY_ERROR_MESSAGE = "[ERROR] 이동 방향은 U또는 D만 입력 가능합니다.";

    public static void validateMoveWay(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(MOVE_WAY_ERROR_MESSAGE);
        }
    }
}
