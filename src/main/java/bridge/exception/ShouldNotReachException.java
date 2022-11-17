package bridge.exception;

public class ShouldNotReachException extends RuntimeException {
    ShouldNotReachException(String message) {
        super(message);
    }
}
