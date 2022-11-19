package bridge.domain.constant;

public enum BridgeComponent {
    BRIDGE_START("["),
    BRIDGE_END("]"),
    BRIDGE_SEPARATOR("|"),
    MOVE_SUCCESS(" O "),
    MOVE_FAILURE(" X "),
    BLANK("   ");

    private final String bridgeComponent;

    BridgeComponent(String bridgeComponent) {
        this.bridgeComponent = bridgeComponent;
    }

    public String get() {
        return bridgeComponent;
    }
}
