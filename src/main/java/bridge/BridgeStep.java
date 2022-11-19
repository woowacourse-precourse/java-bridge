package bridge;

public enum BridgeStep {
    DOWN("D"),
    UP("U");

    private final String value;

    BridgeStep(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
