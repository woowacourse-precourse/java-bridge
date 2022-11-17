package bridge.Enum;

public enum Error {
    BRIDGE_SIZE_FORMAT_ERROR("[ERROR] bridge 사이즈 입력형식이 잘못되었습니다 (숫자만 입력)"),
    BRIDGE_SIZE_RANGE_ERROR("[ERROR] bridge 사이즈 입력 범위가 잘못되었습니다 (3부터 20사이의 숫자)"),

    ;

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
