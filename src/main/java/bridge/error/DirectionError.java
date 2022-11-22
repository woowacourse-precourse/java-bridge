package bridge.error;

public enum DirectionError implements Error {
    INVALID_SYMBOL("올바르지 않은 문자입니다."),
    INVALID_NUMBER("올바르지 않은 숫자입니다."),
    ;

    private final String message;

    DirectionError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
