package bridge.domain;

public enum PassResult {
    PASS("O"),
    FAIL("X"),
    NONE(" ");

    private final String value;

    PassResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
