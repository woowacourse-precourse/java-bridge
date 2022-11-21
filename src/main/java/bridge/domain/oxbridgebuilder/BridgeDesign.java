package bridge.domain.oxbridgebuilder;

public enum BridgeDesign {
    BRIDGE_START("[ "),
    BRIDGE_BLOCK(" | "),
    BRIDGE_END(" ]\n");

    private final String design;

    BridgeDesign(String design) {
        this.design = design;
    }

    public String getDesign() {
        return design;
    }
}
