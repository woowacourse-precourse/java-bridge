package bridge.model;

public enum Moving {
    UP("U"), DOWN("D");

    private final String value;

    Moving(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
