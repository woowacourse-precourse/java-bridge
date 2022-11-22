package bridge.types;

public enum MoveResult {
    PASS(true), FAIL(false);

    private boolean type;

    MoveResult(boolean type) {
        this.type = type;
    }
}