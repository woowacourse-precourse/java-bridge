package bridge.domain.exception;

public class InvalidMoveException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR]";
    public InvalidMoveException() {
        super(ERROR);
    }
}
