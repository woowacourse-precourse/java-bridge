package bridge.model;

public enum MoveResult {
    CORRECT("O"), NOT_CORRECT("X");

    private final String value;

    MoveResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
