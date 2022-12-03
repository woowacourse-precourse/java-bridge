package bridge.enums;

public enum ErrorMessage {

    INVALID_BRIDGE_LENGTH_INPUT("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. "),
    INVALID_DIRECTION_INPUT("[ERROR] U 또는 D를 입력해주세요. "),
    INVALID_RETRY_INPUT("[ERROR] R 또는 Q를 입력해주세요. "),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
