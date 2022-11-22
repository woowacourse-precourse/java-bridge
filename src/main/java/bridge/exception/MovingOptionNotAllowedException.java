package bridge.exception;

public class MovingOptionNotAllowedException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 이동 옵션에 사용되는 입력 값이 아닙니다.";

    public MovingOptionNotAllowedException() {
        super(MESSAGE);
    }
}
