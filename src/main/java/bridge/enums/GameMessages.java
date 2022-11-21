package bridge.enums;

public enum GameMessages {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    RECEIVE_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    RECEIVE_MOVING_DIRECTION_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RECEIVE_GAME_COMMAND_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MESSAGE("\n최종 게임 결과\n"
            + "{0}\n"
            + "{1}\n\n"
            + "게임 성공 여부: {2}\n"
            + "총 시도한 횟수: {3}\n"),
    ;
    private final String gameMessage;

    GameMessages(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    @Override
    public String toString() {
        return gameMessage;
    }
}
