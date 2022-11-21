package bridge.constant;

public enum Error {
    BRIDGE_SIZE_VALID("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    private final String msg;

    Error(String errorMessage) {
        this.msg = DEFAULT_MESSAGE + errorMessage;
    }

    public String getError() {
        return msg;
    }
}
