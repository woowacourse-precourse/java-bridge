package bridge.message;

public enum GameMessage {
    REQUEST_BRIDGE_LENGTH_MESSAGE("다리 길이를 입력해주세요."),
    REQUEST_MOVE_MESSAGE("이동할 칸을 입력해주세요 (위: U, 아래: D)"),
    GAME_SUCCESS_MESSAGE("게임 성공 여부: 성공"),
    GAME_FAIL_MESSAGE("게임 성공 여부: 실패"),
    REQUEST_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT_MESSAGE("최종 게임 결과"),
    TOTAL_COUNT_MESSAGE("총 시도한 횟수: ");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
