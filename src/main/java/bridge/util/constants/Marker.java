package bridge.util.constants;

public enum Marker {
    CROSS_SUCCESS(" O "),
    CROSS_FAIL(" X "),
    NOT_CROSS("   ");

    private String value;
    Marker(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
