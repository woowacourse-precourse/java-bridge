package bridge.domain.constant;

public enum BridgeComponent {
    BRIDGE_BEGIN("["),
    BRIDGE_END("]"),
    BRIDGE_SEPARATOR("|"),
    AVAILABLE_CROSS(" O "),
    UNAVAILABLE_CROSS(" X "),
    BLANK("   ");

    private String component;

    BridgeComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return this.component;
    }
}
