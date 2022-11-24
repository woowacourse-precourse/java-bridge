package bridge.util;

public enum InputConstant {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q");

    private final String value;
    InputConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
