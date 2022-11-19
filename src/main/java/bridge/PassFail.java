package bridge;

public enum PassFail {
    PASS("O"),
    FAIL("X");

    private final String value;

    PassFail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
