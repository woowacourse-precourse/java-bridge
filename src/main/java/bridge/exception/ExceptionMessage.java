package bridge.exception;

public enum ExceptionMessage {
    ERROR_PREFIX("[ERROR] "),
    OUT_OF_BRIDGE_RANGE_EXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NUMBER_FORMAT_EXCEPTION("숫자만 입력 가능합니다."),
    NOT_POSITION_COMMAND_EXCEPTION("U 또는 D만 입력하실 수 있습니다."),
    NOT_POSITION_VALUE_EXCEPTION("0 또는 1만 입력하실 수 있습니다."),
    NOT_RETRY_COMMAND_EXCEPTION("R 또는 Q만 입력하실 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
