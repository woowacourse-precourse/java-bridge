package bridge.domain;

public enum BridgeGameResult {
    SUCCESS("성공"),
    FAIL("실패")
    ;

    private final String result;

    BridgeGameResult(final String message) {
        this.result = message;
    }

    public static BridgeGameResult checkResult(final boolean result){
        if (result){
            return SUCCESS;
        }
        return FAIL;
    }

    public String getResult() {
        return result;
    }
}
