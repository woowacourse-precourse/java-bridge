package bridge.core.exception;

public class CommonException extends RuntimeException {

    private String code;
    private String message;

    private CommonException(String message) {
        super(message);
        this.message = message;
    }

    public CommonException(String code, String message) {
        this(message);
        this.code = code;
    }

    public CommonException(Error error, String... args) {
        this(error.getCode(), error.getMessage(args));
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
