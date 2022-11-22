package bridge.domain;

public enum PlayResult {
    PASS, FAIL;

    public boolean isPass() {
        return this == PASS;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
