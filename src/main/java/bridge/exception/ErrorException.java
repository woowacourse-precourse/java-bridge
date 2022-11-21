package bridge.exception;

public class ErrorException extends IllegalArgumentException {
    public ErrorException() {
    }

    public ErrorException(String s) {
        super(s);
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorException(Throwable cause) {
        super(cause);
    }

    public ErrorException(BrideError errorMessage){
        super(errorMessage.getErrorMessage());
    }
}

