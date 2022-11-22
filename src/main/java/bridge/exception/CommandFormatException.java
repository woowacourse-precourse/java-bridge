package bridge.exception;

public class CommandFormatException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] R 또는 Q만 입력할 수 있습니다.";

    public CommandFormatException() {
        super(ERROR_MESSAGE);
    }
}
