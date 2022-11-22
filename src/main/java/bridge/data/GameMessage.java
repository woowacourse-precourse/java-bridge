package bridge.data;

public enum GameMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_SUCCESS_OR_NOT("게임 성공 여부"),
    TRY_COUNT("총 시도한 횟수"),
    GAME_SUCCESS("성공"),
    GAME_FAILURE("실패"),
    GAME_FINAL_RESULT("최종 게임 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
