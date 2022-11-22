package bridge.Constant;

public enum BridgeValue {

    UP("U"),
    DOWN("D");

    private final String value;

    BridgeValue(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
