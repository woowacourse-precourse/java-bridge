package bridge;

public enum ExceptionMessage {
    BRIDGE_LENGTH_ERROR_MESSAGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;
    ExceptionMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return (message);
    }
}
