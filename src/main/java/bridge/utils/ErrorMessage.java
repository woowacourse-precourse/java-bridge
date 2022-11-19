package bridge.utils;

public enum ErrorMessage {
    INVALID_INPUT_VALUE("올바르지 않은 값입니다."),
    BRIDGE_OUT_OF_RANGE("다리길이는 3 ~ 20사이의 값이여야합니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + this.message;
    }
}
