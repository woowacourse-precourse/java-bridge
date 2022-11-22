package bridge.exception;

public class MoveInputWrongException extends IllegalArgumentException {
    private static final String WRONG_DIRECTION_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다.";

    public MoveInputWrongException() {
        super(WRONG_DIRECTION_MESSAGE);
    }
}
