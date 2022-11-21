package bridge.domain.bridgeGame.gameStatics;

public enum CrossResult {
    FAIL(false, "실패"),
    SUCCESS(true, "성공");

    private final boolean crossSuccess;
    private final String result;

    CrossResult(boolean crossSuccess, String result) {
        this.crossSuccess = crossSuccess;
        this.result = result;
    }

    public static CrossResult get(boolean crossSuccess) {
        if (crossSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    public boolean getValue() {
        return crossSuccess;
    }

    public String toString() {
        return result;
    }
}
