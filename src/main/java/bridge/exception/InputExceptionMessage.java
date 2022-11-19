package bridge.exception;

public enum InputExceptionMessage {
    INPUT_NOT_FIND_EXCEPTION("입력 값이 존재하지 않습니다."),
    BRIDGE_RANGE_EXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    InputExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return ERROR_PREFIX + message;
    }
}
