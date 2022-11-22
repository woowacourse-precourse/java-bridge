package bridge.response;

public class UserInputException extends IllegalArgumentException {

    public UserInputException() {
    }

    public UserInputException(String s) {
        super(s);
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInputException(Throwable cause) {
        super(cause);
    }

    public UserInputException(ErrorResponse errorResponse) {
        super(errorResponse.getErrorMessage());
    }
}
