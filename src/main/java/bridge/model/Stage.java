package bridge.model;

public enum Stage {
    EMPTY(" "),
    UP("U"),
    DOWN("D");

    private final String value;

    Stage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
