package bridge.exception;

public class MoveValueException extends IllegalArgumentException{

    private static final String EXCEPTION_MESSAGE_MOVE_VALUE = "[ERROR] 이동 가능 칸은 %s 또는 %s 만 있습니다.";

    public MoveValueException(String up, String down) {
        super(String.format(EXCEPTION_MESSAGE_MOVE_VALUE, up, down));
    }
}
