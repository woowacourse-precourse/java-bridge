package bridge.type;

public enum OutputMessageType {

    MAP_HEAD("[ "),
    MAP_DELIMITER(" | "),
    MAP_TAIL(" ]"),
    MAP_O_MARK("O"),
    MAP_X_MARK("X"),
    MAP_BLANK(" "),
    RESULT_HEAD("\n최종 게임 결과"),
    RESULT_PASS_OR_FAIL("\n게임 성공 여부: %s"),
    RESULT_PASS("성공"),
    RESULT_FAIL("실패"),
    RESULT_TRY_COUNT("총 시도한 횟수: %d");

    private final String message;

    OutputMessageType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
