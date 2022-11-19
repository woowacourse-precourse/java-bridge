package bridge.exception;

public enum InputViewExceptionMessage {

    READ_BRIDGE_SIZE_NOT_DIGIT_EXCEPTION("[ERROR] - 다리 길이의 입력값은 숫자여야 합니다."),
    BRIDGE_SIZE_OVER_RANGE_EXCEPTION("[ERROR] - 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String message;

    InputViewExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
