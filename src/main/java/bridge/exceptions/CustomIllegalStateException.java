package bridge.exceptions;

public class CustomIllegalStateException extends IllegalStateException {
    public CustomIllegalStateException(String message) {
        super(CustomExceptionMessageFormat.apply(message));
    }
}
