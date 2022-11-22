package bridge.combinator;

public enum BridgeState {
    TRUE(true, "O"),
    FALSE(false, "X"),
    NOTHING(false, "");

    private final boolean state;

    private final String shape;

    BridgeState(boolean state, String shape) {
        this.state = state;
        this.shape = shape;
    }

    public boolean isState() {
        return state;
    }

    public String getShape() {
        return shape;
    }
}
