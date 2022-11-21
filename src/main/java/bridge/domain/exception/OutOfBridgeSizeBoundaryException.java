package bridge.domain.exception;

public class OutOfBridgeSizeBoundaryException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR]";
    public OutOfBridgeSizeBoundaryException() {
        super(ERROR);
    }
}
