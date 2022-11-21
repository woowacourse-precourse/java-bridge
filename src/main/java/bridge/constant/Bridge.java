package bridge.constant;

public enum Bridge {
    O(" O "),
    X(" X "),
    BLANK("   "),
    OPEN("["),
    MIDDLE("|"),
    CLOSE("]");

    private final String state;

    private Bridge(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
