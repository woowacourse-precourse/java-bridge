package bridge.Constant;

public enum BridgeValue {

    TRUE(" O "),
    FALSE(" X "),
    EMPTY("   "),
    UP("U"),
    DOWN("D"),
    OLD(", "),
    NEW("|");

    private final String value;

    BridgeValue(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
