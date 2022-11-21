package bridge.constant;

public enum BridgeSymbol {
    O(" O "),
    X(" X "),
    BLANK("   "),
    OPEN("["),
    MIDDLE("|"),
    CLOSE("]"),
    SUCCESS("성공"),
    FAIL("실패"),
    RETRY("R"),
    QUIT("Q");

    private final String state;

    private BridgeSymbol(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
