package bridge.util;

public enum BridgePart {
    OK("O"),
    NO("X"),
    PARTITION("|"),
    START_EDGE("["),
    END_EDGE("]"),
    BLANK(" ");


    private final String value;

    BridgePart(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
