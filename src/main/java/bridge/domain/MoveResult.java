package bridge.domain;

public enum MoveResult {
    PASS("O"),
    FAIL("X"),
    NONE(" ");

    private final String value;

    MoveResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
