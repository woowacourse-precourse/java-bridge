package bridge.Message;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE_MESSAGE("[ERROR] 3 이상 20 이하의 숫자만 입력해주세요."),
    INVALID_MOVE_COMMAND_MESSAGE("[ERROR] U 또는 D 중 하나만 입력해주세요."),
    INVALID_RETRY_COMMAND_MESSAGE("[ERROR] R 또는 Q 중 하나만 입력해주세요.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
