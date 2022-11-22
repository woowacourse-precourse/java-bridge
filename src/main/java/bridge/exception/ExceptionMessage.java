package bridge.exception;

public enum ExceptionMessage {
    ERROR_MESSAGE_PREFIX("[ERROR] "),
    BRIDGE_SIZE_IS_NULL_ERROR("다리의 길이를 입력 해주세요."),
    BRIDGE_SIZE_IS_NOT_NUMBER_ERROR("다리의 길이는 정수만 입력 가능합니다."),
    BRIDGE_SIZE_RANGE_ERROR("다리의 길이는 3 이상 20 이하의 정수이어야 합니다."),
    COMMEND_NOT_FOUND_ERROR("입력 가능한 선택지는 'R'과 'Q' 입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE_PREFIX.message + this.message;
    }
}
