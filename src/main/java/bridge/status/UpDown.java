package bridge.status;

public enum UpDown {
    UP("U"),
    DOWN("D");

    private final String value;

    UpDown(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
