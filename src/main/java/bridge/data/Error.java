package bridge.data;

public enum Error {
    INVALID_BRIDGE_LENGTH_TYPE_MESSAGE("[ERROR] 숫자를 입력해주세요."),
    INVALID_MOVING_COMMAND_MESSAGE("[ERROR] U 또는 D를 입력해주세요."),
    INVALID_NUMBER_RANGE_MESSAGE("[ERROR] 3 이상 20 이하의 숫자를 입력해주세요."),
    INVALID_RETRY_COMMAND_MESSAGE("[ERROR] R 또는 Q를 입력해주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
