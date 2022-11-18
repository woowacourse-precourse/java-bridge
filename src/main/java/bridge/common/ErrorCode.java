package bridge.common;

public enum ErrorCode {
    INVALID_BRIDGE_SIZE("각 자리의 수의 가능한 범위는 3 ~ 20 입니다."),
    INVALID_MOVING("U 또는 D만 입력 가능합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
