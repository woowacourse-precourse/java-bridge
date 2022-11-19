package bridge;

public enum UpDown {
    UP("U"),
    DOWN("D");

    private final String value;

    public String getValue() {
        return value;
    }

    UpDown(String value) {
        this.value = value;
    }
}
