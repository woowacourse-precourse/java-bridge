package bridge.output;

public enum Guide {

    START("다리 건너기 게임을 시작합니다."),
    FINISH("\n최종 게임 결과"),
    RESULT("\n게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TOTAL_TRY("총 시도한 횟수: ");

    private final String message;

    Guide(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
