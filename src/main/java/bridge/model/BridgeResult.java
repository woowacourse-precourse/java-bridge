package bridge.model;

public enum BridgeResult {
    SUCCESS("O"),
    FAIL("X"),
    NONE(" ");

    private final String value;

    BridgeResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
