package bridge.core.exception;

public class InvalidInputException extends IllegalArgumentException {

    private String code;
    private String message;

    private InvalidInputException(String message) {
        super(message);
        this.message = message;
    }

    public InvalidInputException(String code, String message) {
        this(message);
        this.code = code;
    }

    public InvalidInputException(Error error, String... args) {
        this(error.getCode(), error.getMessage(args));
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
