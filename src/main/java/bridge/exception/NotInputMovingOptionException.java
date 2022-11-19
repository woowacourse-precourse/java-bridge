package bridge.exception;

public class NotInputMovingOptionException extends RuntimeException {

    private static final String MESSAGE = "[ERROR] 이동할 칸에 대해 입력해주세요.";

    public NotInputMovingOptionException() {
        super(MESSAGE);
    }
}
