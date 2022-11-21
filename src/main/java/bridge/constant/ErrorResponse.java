package bridge.constant;

public enum ErrorResponse {

    INVALID_BRIDGE_LENGTH(new IllegalArgumentException("[ERROR] 올바르지 않은 다리 길이 입니다.")),
    INVALID_BRIDGE_INPUT_TYPE(new IllegalArgumentException("[ERROR] 다리 길이 입력은 숫자 형식입니다.")),
    INVALID_INPUT_MOVING_DIRECTION(new IllegalArgumentException("[ERROR] 이동 방향은 위, 아래로 제한됩니다.")),
    INVALID_INPUT_GAME_COMMAND(new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q로 제한됩니다."));


    private final RuntimeException exception;

    ErrorResponse(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getValue() {
        return this.exception;
    }
}
