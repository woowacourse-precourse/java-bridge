package bridge.exception;

public class NotNumericException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 올바른 숫자 입력이 아닙니다.";

    public NotNumericException() {
        super(ERROR_MESSAGE);
    }
}
