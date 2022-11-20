package bridge.exception;

public class InvalidDirectionFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] U 혹은 D를 입력해야 합니다.";

    public InvalidDirectionFormatException() {
        super(ERROR_MESSAGE);
    }
}
