package bridge.data;

public enum Game {
    BRIDGE_LENGTH_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    FAIL("실패"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    GAME_SUCCESS_OR_FAIL("게임 성공 여부: "),
    MOVING_CHOICE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    SUCCESS("성공"),
    TOTAL_TRY("총 시도한 횟수: ");

    private final String message;

    Game(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
