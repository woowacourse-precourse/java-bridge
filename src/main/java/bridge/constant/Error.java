package bridge.constant;

public enum Error {
    BRIDGE_SIZE_VALID("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVEMENT_VALID("이동할 수 있는 칸은 U나 D만 입력 가능합니다.");
    private static final String DEFAULT_MESSAGE = "[ERROR] ";
    private final String msg;

    Error(String errorMessage) {
        this.msg = DEFAULT_MESSAGE + errorMessage;
    }

    public String getError() {
        return msg;
    }
}
