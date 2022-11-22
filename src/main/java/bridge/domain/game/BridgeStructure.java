package bridge.domain.game;

public enum BridgeStructure {
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_CELL(" | "),
    BRIDGE_ROW("\n"),
    BRIDGE_EMPTY(" ");

    private final String shape;

    BridgeStructure(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
