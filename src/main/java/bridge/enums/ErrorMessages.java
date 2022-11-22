package bridge.enums;

/**
 * 발생할 수 있는 에러에 대한 에러메시지를 나타낸다.
 */
public enum ErrorMessages {
    BRIDGE_SIZE_ERROR_MESSAGE("[ERROR] 다리의 길이는 3이상 20이하의 숫자여야 합니다.\n"),
    MOVING_DIRECTION_ERROR_MESSAGE("[ERROR] 이동방향은 U 또는 D여야 합니다.(위: U, 아래: D)\n"),
    GAME_COMMAND_ERROR_MESSAGE("[ERROR] 게임 재시작 여부는 R 또는 Q여야 합니다.(재시작: R, 종료: Q)\n"),
    ;
    private final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
