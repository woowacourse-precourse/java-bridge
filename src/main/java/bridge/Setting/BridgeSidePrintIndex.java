package bridge.Setting;

public enum BridgeSidePrintIndex {
    CORRECT("O"),
    WRONG("X"),
    BLANK(" ");

    private final String label;

    BridgeSidePrintIndex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
