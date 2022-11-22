package bridge.Setting;

public enum BridgeRetryIndex {
    RETRY("R"),
    QUIT("Q");

    private final String label;

    BridgeRetryIndex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
