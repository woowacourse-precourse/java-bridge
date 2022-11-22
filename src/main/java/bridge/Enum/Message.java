package bridge.Enum;

public enum Message {
    SELECT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SELECT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MESSAGE_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    TOTAL_RESULT("\n최종 게임 결과"),
    SUCCESS_RESULT("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패"),
    ;
    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
