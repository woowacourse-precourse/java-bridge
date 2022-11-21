package response;

public class GameException extends IllegalStateException {
    public GameException() {
    }

    public GameException(String s) {
        super(s);
    }

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameException(Throwable cause) {
        super(cause);
    }

    public GameException(ErrorResponse errorResponse) {
        super(errorResponse.getErrorMessage());
    }
}
