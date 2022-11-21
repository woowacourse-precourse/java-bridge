package bridge.message;

public enum ErrorMessage {
    NOT_NUMBER_BRIDGE_SIZE("[ERROR] 다리 길이는 숫자입니다."),
    NOT_IN_RANGE_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_MOVE_VALID_STRING("[ERROR] U와 D만 입력할 수 있습니다."),
    NOT_RESTART_QUICK_VALID_STRING("[ERROR] R와 Q만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
