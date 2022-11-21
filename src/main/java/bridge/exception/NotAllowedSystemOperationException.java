package bridge.exception;

public class NotAllowedSystemOperationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 종료는 Q, 재시작은 R을 입력하세요.";

    public NotAllowedSystemOperationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
