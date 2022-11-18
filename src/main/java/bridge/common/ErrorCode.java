package bridge.common;

public enum ErrorCode {
    INVALID_RANGE("각 자리의 수의 가능한 범위는 3 ~ 20 입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
