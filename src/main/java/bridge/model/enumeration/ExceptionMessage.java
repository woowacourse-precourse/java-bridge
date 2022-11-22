package bridge.model.enumeration;

public enum ExceptionMessage {

    PREFIX("\n[ERROR] "),
    INVALID_INPUT_ONLY_NUMBER("숫자만을 입력해야 합니다."),
    INVALID_BRIDGE_COMMAND("다리에는 \"U\"와 \"D\"만 포함되어야 합니다."),
    INVALID_NUMBER_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING_COMMAND("다리 이동값은 \"U\"이거나 \"D\"이어야 합니다."),
    INVALID_RESTARTING_COMMAND("재시작 결정값은 \"R\"이거나 \"Q\"이어야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
