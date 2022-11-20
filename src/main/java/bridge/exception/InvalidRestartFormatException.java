package bridge.exception;

public class InvalidRestartFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] R 혹은 Q를 입력해야 합니다.";

    public InvalidRestartFormatException() {
        super(ERROR_MESSAGE);
    }
}
