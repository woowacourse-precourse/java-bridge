package bridge.domain;

public enum ResultGenerator {

    IS_SUCCESS("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    ;

    private final String message;

    ResultGenerator(String message) {
        this.message = message;
    }

    private static String isSuccess(boolean isEnd) {
        if (isEnd) {
            return SUCCESS.message;
        }

        return FAIL.message;
    }

    public static String generateResult(boolean isEnd, int trial) {
        return IS_SUCCESS.message + isSuccess(isEnd);
    }
}
