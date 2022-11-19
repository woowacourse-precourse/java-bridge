package bridge.messages;

public enum ErrorMessage {
    PREFIX_ERROR_MESSAGE("[ERROR] "),
    INVALID_BRIDGE_SIZE(PREFIX_ERROR_MESSAGE.getMessage() + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
