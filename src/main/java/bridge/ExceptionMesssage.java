package bridge;

public enum ExceptionMesssage {
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    ExceptionMesssage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
