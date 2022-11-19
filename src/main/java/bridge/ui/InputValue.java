package bridge.ui;

public enum InputValue {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String value;

    InputValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
