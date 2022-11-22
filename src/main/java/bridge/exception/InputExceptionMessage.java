package bridge.exception;

public enum InputExceptionMessage {
    INPUT_NOT_FIND_EXCEPTION("입력 값이 존재하지 않습니다."),
    BRIDGE_RANGE_EXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NULL_EXCEPTION("NULL 값이 포함되어 있습니다."),
    INVALID_NUMBER_EXCEPTION("숫자 이외의 값이 포함되어 있습니다."),
    OUT_OF_RANGE_EXCEPTION("숫자 범위를 벗어났습니다."),
    RETRY_INCORRECT_INPUT_EXCEPTION("R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    InputExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return ERROR_PREFIX + message;
    }
}
