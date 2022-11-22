package bridge.status;

public enum PassOrNot {
    PASS("O"),
    NO_PASS("X");

    private final String value;

    PassOrNot(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
