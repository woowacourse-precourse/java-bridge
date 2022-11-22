package bridge;

public enum ErrorMessage {
    BRIDGE_OUT_OF_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    WRONG_INPUT("잘못된 입력입니다.");

    private final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    @Override
    public String toString() {
        return message;
    }
}
