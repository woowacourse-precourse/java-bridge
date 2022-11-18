package bridge.output.message;

public enum Status {

    START("다리 건너기 게임을 시작합니다."),
    FINISH("최종 게임 결과"),
    SUCCESS_OR_NOT("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    TOTAL_TRY("총 시도한 횟수: ");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
