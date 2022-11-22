package bridge.model.constant;

public enum BridgeMovable {

    ABLE(true, true, "O"),
    UNABLE(true, false, "X"),
    EMPTY(false, false, " ");

    private final boolean status;
    private final boolean match;
    private final String value;

    BridgeMovable(boolean status, boolean match, String value) {
        this.status = status;
        this.match = match;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BridgeMovable get(boolean match, boolean status) {
        if (!match) {
            return EMPTY;
        }
        if (status) {
            return ABLE;
        }
        return UNABLE;
    }
}
