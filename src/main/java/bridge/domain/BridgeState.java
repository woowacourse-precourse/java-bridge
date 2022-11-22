package bridge.domain;

public enum BridgeState {
    CORRECT(" O "),
    WRONG(" X "),
    NONE("   "),
    START("["),
    PARTITION("|"),
    END("]");

    private String mark;

    BridgeState(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }
}
