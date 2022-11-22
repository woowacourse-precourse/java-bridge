package bridge.model.enumeration;

public enum ExceptionMessage {

    PREFIX("\n[ERROR] "),
    INVALID_INPUT_ONLY_NUMBER("숫자만을 입력해야 합니다."),
    INVALID_NUMBER_RANGE("다리의 길이 범위는 3부터 20까지입니다."),
    INVALID_MOVING_INPUT("다리 이동값은 \"U\"이거나 \"D\"이어야 합니다."),
    INVALID_RESTART_INPUT("재시작 결정값은 \"R\"이거나 \"Q\"이어야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
