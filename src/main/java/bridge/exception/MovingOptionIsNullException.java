package bridge.exception;

public class MovingOptionIsNullException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 입력 값이 null 입니다.";

    public MovingOptionIsNullException() {
        super();
    }
}
