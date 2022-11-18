package bridge.enums;

public enum ErrorMessages {
    BRIDGE_LENGTH_ERROR_MESSAGE("다리의 길이는 3이상 20이하의 숫자여야 합니다."),
    MOVING_DIRECTION_ERROR_MESSAGE("이동방향은 U 또는 D여야 합니다.(위: U, 아래: D)"),
    GAME_COMMAND_ERROR_MESSAGE("게임 재시작 여부는 R 또는 Q여야 합니다.(재시작: R, 종료: Q)"),
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
