package bridge;

public enum Message {
    PRINT_START("다리 건너기 게임을 시작합니다."),
    PRINT_FINAL_RESULT("최종 게임 결과"),
    PRINT_IS_SUCCESSFUL("게임 성공 여부: "),
    PRINT_NUMBER_OF_ATTEMPTS("총 시도한 횟수: "),

    FAIL("실패"),
    SUCCESS("성공")
    ;



    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
