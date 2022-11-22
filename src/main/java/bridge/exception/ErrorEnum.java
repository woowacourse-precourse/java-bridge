package bridge.exception;

public enum ErrorEnum {
    INVALID_INTEGER_INPUT("[ERROR] int로 변환 불가능한 입력을 했습니다."),
    INVALID_DIRECTION_INPUT("[ERROR] U 또는 D를 입력 해야 합니다."),
    INVALID_COMMAND_INPUT("[ERROR] Q 또는 R를 입력 해야 합니다."),
    INVALID_RANDOM_NUMBER("[ERROR] 0 또는 1의 숫자를 입력 해야 합니다."),

    INVALID_BRIDGE_INDEX("[ERROR] 다리의 인덱스 범위를 벗어났습니다."),
    INVALID_BRIDGE_SIZE("[ERROR] 다리의 크기는 3 ~ 20 범위를 가져야 합니다."),

    INVALID_BRIDGE_SIZE_STATE("[ERROR] 다리 상하의 길이가 일치하지 않습니다."),
    INVALID_BRIDGE_DIRECTION_STATE("[ERROR] 다리에 위 아래 중 어느 방향도 존재하지 않습니다."),
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
