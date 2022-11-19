package bridge.utils;

public enum ErrorMessage {
    INVALID_INPUT_VALUE("올바르지 않은 값입니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + this.message;
    }
}
