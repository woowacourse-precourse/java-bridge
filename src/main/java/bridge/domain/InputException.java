package bridge.domain;

public enum InputException {
    BLANK_BRIDGE_LENGTH("다리 길이가 입력되지 않았습니다."),
    NOT_NUMBER_BRIDGE_LENGTH("다리 길이는 숫자로 입력해야 합니다."),
    OUT_OF_RANGE_BRIDGE_LENGTH("다리 길이는 3 이상 20 이하의 숫자여야 합니다."),
    BLANK_PLAYER_MOVE("플레이어가 이동할 칸이 입력되지 않았습니다."),
    INVALID_PLAYER_MOVE("플레이어가 이동할 칸은 U 또는 D으로 입력되어야 합니다."),
    BLANK_GAME_END_INPUT("게임 재시작/종료 여부가 입력되지 않았습니다."),
    INVALID_GAME_END_INPUT("게임 재시작/종료 입력은 R 또는 Q로 입력되어야 합니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
