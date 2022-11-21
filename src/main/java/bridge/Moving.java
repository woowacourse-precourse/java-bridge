package bridge;

public enum Moving {
    DOWN("D"),
    UP("U");

    private final String value;

    Moving(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
