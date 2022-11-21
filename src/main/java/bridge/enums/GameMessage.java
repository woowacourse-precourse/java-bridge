package bridge.enums;

public enum GameMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해 주세요."),
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REGAME_OR_END("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: "),
    ATTEMPT("총 시도한 횟수: ");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getMessage() {
        return gameMessage;
    }
}
