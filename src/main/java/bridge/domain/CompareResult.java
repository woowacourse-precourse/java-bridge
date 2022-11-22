package bridge.domain;

public enum CompareResult {
    PASS, FAIL;

    public boolean isPass() {
        return this == PASS;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
