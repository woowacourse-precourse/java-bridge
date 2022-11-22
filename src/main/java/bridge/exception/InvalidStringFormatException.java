package bridge.exception;

public class InvalidStringFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 문자를 입력해주세요.";

    public InvalidStringFormatException() {
        super(ERROR_MESSAGE);
    }
}
