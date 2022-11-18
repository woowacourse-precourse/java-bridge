package bridge;

public enum Sentence {
    START("다리 건너기 게임을 시작합니다."),
    INPUT_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_SPACE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_END("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    OUTPUT_RESULT("최종 게임 결과"),
    OUPTUT_SUCCESS("게임 성공 여부: 성공"),
    OUTPUT_FAIL("게임 성공 여부: 실패"),
    OUTPUT_TRY("총 시도한 횟수: "),
    ;

    private final String sentence;

    Sentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return this.sentence;
    }
}
