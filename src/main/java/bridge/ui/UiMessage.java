package bridge.ui;

public enum UiMessage {
    OUTPUT_GAME_START("다리 건너기 게임을 시작합니다.\n"),
    OUTPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    OUTPUT_CHOICE_MOVE_SPACE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    OUTPUT_CHOICE_RETRY_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_FINAL_GAME_RESULT("최종 게임 결과"),
    OUTPUT_TOTAL_TRY("총 시도한 횟수: "),
    OUTPUT_GAME_FAIL("게임 성공 여부: 실패"),
    OUTPUT_GAME_SUCCESS("게임 성공 여부: 성공");

    private final String message;

    UiMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
