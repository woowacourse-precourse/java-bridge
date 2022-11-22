package bridge.domain.exception;

public class BridgeSizeOutOfBoundaryException extends IllegalArgumentException {

    public BridgeSizeOutOfBoundaryException() {
    }

    public BridgeSizeOutOfBoundaryException(String s) {
        super(s);
    }
}
