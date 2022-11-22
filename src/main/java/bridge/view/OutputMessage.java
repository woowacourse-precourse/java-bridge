package bridge.view;

public enum OutputMessage {
    BRIDGE_MATCHED("O"),
    BRIDGE_UNMATCHED("X"),
    BRIDGE_EMPTY(" "),
    BRIDGE_START("[ "),
    BRIDGE_SEPARATOR(" | "),
    BRIDGE_END(" ]"),

    GAME_START("다리 건너기 게임을 시작합니다."),
    GAME_REQUEST_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    GAME_END("최종 게임 결과"),
    GAME_WHETHER_SUCCESS("게임 성공 여부: "),
    GAME_TOTAL_TRY_COUNT("총 시도한 횟수: "),

    GAME_REQUEST_POSITION("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n"),
    GAME_REQUEST_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시작: %s, 종료: %s)\n"),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    ;
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
