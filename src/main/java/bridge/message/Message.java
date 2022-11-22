package bridge.message;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료:Q)"),
    RESULT("최종 게임 결과"),
    GAME_SUCCESS("최종 게임 결과: 성공"),
    GAME_FAIL("최종 게임 결과: 실패"),
    TRY_NUMBER("총 시도한 횟수: "),
    START_MAP("["),
    END_MAP("]"),
    SPLIT_MAP("|"),
    BLANK(" "),
    CORRECT("O"),
    WRONG("X"),
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
