package bridge.constant.message;

public enum OutputMessage {
    RESULT("최종 게임 결과")
    , SUCCESS_OR_FAILURE("게임 성공 여부: %s")
    , TOTAL_ATTEMPTS("총 시도한 횟수: %d")
    ;

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
