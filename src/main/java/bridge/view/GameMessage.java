package bridge.view;

public enum GameMessage {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_MESSAGE("최종 게임 결과"),
    GAME_WIN_MESSAGE("게임 성공 여부: 성공"),
    GAME_FAIL_MESSAGE("게임 성공 여부: 실패"),
    GAME_TRY_COUNT_MESSAGE("총 시도한 횟수: ");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }
}
