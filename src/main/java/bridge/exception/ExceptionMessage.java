package bridge.exception;

public enum ExceptionMessage {
    ERROR_PREFIX("[ERROR] "),
    OUT_OF_BRIDGE_RANGE_EXCEPTION("다리의 길이는 3이상 20이하만 입력 가능합니다."),
    NUMBER_FORMAT_EXCEPTION("숫자만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
