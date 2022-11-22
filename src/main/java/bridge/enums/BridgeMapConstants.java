package bridge.enums;

public enum BridgeMapConstants {
    STARTER("["),
    ENDER("]"),
    DIVIDER("|"),
    LINE_JUMPER("\n"),
    ;

    private final String value;

    private BridgeMapConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
