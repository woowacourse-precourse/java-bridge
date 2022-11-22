package bridge.Setting;

public enum BridgeSideIndex {
    UP("U", "위"),
    DOWN("D", "아래");

    private final String label;
    private final String position;

    BridgeSideIndex(String label, String position) {
        this.label = label;
        this.position = position;
    }

    public String getLabel() {
        return label;
    }

    public String getPosition() {
        return position;
    }
}
