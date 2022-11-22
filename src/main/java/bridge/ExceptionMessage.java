package bridge;

public enum ExceptionMessage {
    BRIDGE_LENGTH_ERROR_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING_ERROR_MESSAGE("[ERROR] 이동할 칸은 U 또는 D만 입력할 수 있습니다."),
    INVALID_STATUS_ERROR_MESSAGE("[ERROR] 게임 상태 입력값은 R 또는 Q만 입력할 수 있습니다.");
    private final String message;
    ExceptionMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return (message);
    }
}
