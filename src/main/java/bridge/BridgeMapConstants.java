package bridge;

public enum BridgeMapConstants {
    STARTER("["),
    ENDER("]"),
    DIVIDER("|"),
    LINE_JUMPER("\n"),
    ;

    private String value;

    private BridgeMapConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
