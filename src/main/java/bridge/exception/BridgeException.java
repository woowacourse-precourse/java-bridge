package bridge.exception;

public enum BridgeException {
    NOT_DISIT("숫자가 아닙니다."),
    INVALID_LENGTH_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVE("'U' 또는 'D' 둘 중 하나의 입력이여야 합니다."),
    INVALID_RESTART_STATUS("'R' 또는 'Q' 둘 중 하나의 입력이여야 합니다.");

    private final String errorMessage;

    BridgeException(String errorMessage) {
        this.errorMessage = "[ERROR]" + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}