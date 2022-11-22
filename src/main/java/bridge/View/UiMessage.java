package bridge.View;

public enum UiMessage {
    PLEASE_INPUT_BRIDGE_SIZE("다리의 길이를 입력해 주세요."),
    PLEASE_INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    PLEASE_INPUT_RETRY_OR_NOT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    ERROR_ENTERED_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_ENTERED_MOVING("[ERROR] 이동할 칸은 U 또는 D 이여야 합니다."),
    ERROR_ENTERED_RETRY_OR_NOT("[ERROR] 재시도 여부 입력은 R 또는 Q 이여야 합니다."),
    EMPTY_GRAPH("[]"),
    FINAL_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    GAME_FAIL("게임 성공 여부: 실패"),
    TOTAL_TRY("총 시도한 횟수: "),
    FIRST_X(" X ]"),
    FIRST_O(" O ]"),
    FIRST_BLANK("   ]"),
    O_AFTER_FIRST("| O ]"),
    X_AFTER_FIRST("| X ]"),
    BLACK_AFTER_FIRST("|   ]");

    private final String value;

    UiMessage(String s) {
        this.value = s;
    }

    public String getValue() {
        return this.value;
    }
}
