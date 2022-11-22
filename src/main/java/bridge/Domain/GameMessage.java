package bridge.Domain;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_PHRASE("다리의 길이를 입력해주세요."),
    MOVING_BRIDGE_PHRASE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    QUIT_OR_RESTART_PHRASE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    iS_SUCCESS_OR_NOT("게임 성공 여부: "),
    SUCCESS_PHRASE("성공"),
    FAILURE_PHRASE("실패"),
    TRY_AMOUNT_PHARASE("총 시도한 횟수: ");
    ;

    private final String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }
}
