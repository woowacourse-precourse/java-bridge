package bridge.exception;

public class InvalidNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    public InvalidNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
