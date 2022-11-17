package bridge.exception;

public class MoveSpaceException {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String WRONG_SPACE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U(위), D(아래)로 입력해야 합니다.";

    public static void validate(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(WRONG_SPACE_ERROR_MESSAGE);
        }
    }
}
