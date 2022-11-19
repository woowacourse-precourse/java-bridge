package bridge.exception;

public enum Errors {
    INVALID_PARAMETER("파라미터의 값이 잘못 되었습니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";

    private final String message;

    Errors(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT_MESSAGE + this.message;
    }
}
