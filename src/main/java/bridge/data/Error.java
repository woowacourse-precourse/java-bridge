package bridge.data;

public enum Error {
    INVALID_BRIDGE_LENGTH_TYPE_MESSAGE("숫자를 입력해주세요."),
    INVALID_MOVING_COMMAND_MESSAGE("U 또는 D를 입력해주세요."),
    INVALID_NUMBER_RANGE_MESSAGE("3 이상 20 이하의 숫자를 입력해주세요."),
    INVALID_RETRY_COMMAND_MESSAGE("R 또는 Q를 입력해주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        String error = "[ERROR] ";
        return error + message;
    }
}
