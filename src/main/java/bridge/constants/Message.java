package bridge.constants;

public enum Message {

    ERROR_PREFIX("[ERROR] "),
    START_GAME("다리 건너기 게임을 시작합니다."),
    REQUEST_SIZE("다리의 길이를 입력해주세요."),
    REQUEST_BRIDGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    REQUEST_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_GAME("최종 게임 결과"),
    SUCCESS_WHETHER("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패"),
    EMPTY("");


    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
