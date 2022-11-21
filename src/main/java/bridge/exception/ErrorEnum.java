package bridge.exception;

public enum ErrorEnum {
    INVALID_BRIDGE_SIZE_STATE("[ERROR] 다리 상하의 길이가 일치하지 않습니다."),
    INVALID_BRIDGE_DIRECTION_STATE("[ERROR] 다리에 위 아래 중 어느 방향도 존재하지 않습니다."),
    INVALID_BRIDGE_INDEX("[ERROR] 다리의 인덱스 범위를 벗어났습니다."),

    INVALID_DIRECTION_INPUT("[ERROR] U 또는 D를 입력 해야 합니다."),
    INVALID_BRIDGE_GAME_MOVE_STATUS("[ERROR] 이동하려면 RUNNING 상태여야 합니다."),
    ;
    private final String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public String messageWithCause(String cause) {
        return this.message + " " + cause;
    }
}
