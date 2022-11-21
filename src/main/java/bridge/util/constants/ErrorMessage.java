package bridge.util.constants;

public enum ErrorMessage {
    NUMERIC_ERROR_MESSAGE("입력된 값이 정수가 아닙니다"),
    GAME_COMMAND_INPUT_ERROR("입력된 값이 %s이나 %s가 아닙니다"),
    MOVING_SPACE_INPUT_ERROR("입력된 값이 %s나 %s가 아닙니다"),
    BRIDGE_LENGTH_ERROR("다리 길이는 %d ~ %d사이여야 합니다"),
    BRIDGE_NUMBER_ERROR("생성된 다리번호가 유효하지 않습니다"),
    BRIDGE_INDEX_ERROR("다리의 길이에 맞지 않는 인덱스가 인자로 쓰였습니다 : %d"),
    BRIDGE_INVALID_ERROR("생성된 다리가 유효하지 않습니다"),
    MOVE_INVALID_ERROR("유효하지 않은 상태에서 move가 호출됐습니다");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
