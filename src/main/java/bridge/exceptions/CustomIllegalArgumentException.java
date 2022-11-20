package bridge.exceptions;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public CustomIllegalArgumentException(String message) {
        super(CustomExceptionMessageFormat.apply(message));
    }
}
