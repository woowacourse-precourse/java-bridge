package bridge.domain.bridgemaking;

public enum BridgeComponent {
    HEAD("["),
    TAIL("]"),
    DELIMITER("|"),
    BLANK(" "),
    CROSS_SUCCEEDED("O"),
    CROSS_FAILED("X");

    private final String component;

    BridgeComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }
}
