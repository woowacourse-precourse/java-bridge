package bridge.messages;

public enum ResultMessage {
    FINAL_GAME_RESULT_MAP("최종 게임 결과"),
    SUCCESS_OR_FAIL("게임 성공 여부: "),
    SUCCESS(SUCCESS_OR_FAIL.getMessage() + "성공"),
    FAIL(SUCCESS_OR_FAIL.getMessage() + "실패"),
    TRY_COUNT_MESSAGE("총 시도한 횟수: ");
    String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
