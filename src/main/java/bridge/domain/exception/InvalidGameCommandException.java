package bridge.domain.exception;

public class InvalidGameCommandException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR]";
    public InvalidGameCommandException() {
        super(ERROR);
    }
}
