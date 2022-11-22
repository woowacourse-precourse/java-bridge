package bridge.constants;

public enum GuideSentences {
    START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVING_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    IS_SUCCESS("게임 성공 여부: "),
    COUNT_OF_TRY("총 시도한 횟수: ");

    private final String sentence;

    GuideSentences(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }
}
