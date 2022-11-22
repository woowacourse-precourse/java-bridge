package bridge.Setting;

public enum BridgeSideIndex {
    UP("U"),
    DOWN("D");

    private final String label;

    BridgeSideIndex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
