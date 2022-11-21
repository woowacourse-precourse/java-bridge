package bridge.constant;

public enum BridgeSymbol {
    O(" O "),
    X(" X "),
    BLANK("   "),
    OPEN("["),
    MIDDLE("|"),
    CLOSE("]");

    private final String state;

    private BridgeSymbol(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
