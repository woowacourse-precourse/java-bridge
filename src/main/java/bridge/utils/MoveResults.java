package bridge.utils;

public enum MoveResults {
    SUCCESS(" O "),
    FAIL(" X "),
    NONE("   ");

    private final String value;

    MoveResults(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isEqualValue(String value) {
        return this.value.equals(value);
    }
}
