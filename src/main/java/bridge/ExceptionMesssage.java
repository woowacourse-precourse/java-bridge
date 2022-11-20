package bridge;

public enum ExceptionMesssage {
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_STAIRS_TYPE_ERROR("[ERROR] 해당 칸을 찾을 수 없습니다.");

    private final String message;

    ExceptionMesssage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
