package bridge.exception;

public class NotAllowedDirectionException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] U 또는 D만 입력 가능합니다.";

    public NotAllowedDirectionException() {
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
