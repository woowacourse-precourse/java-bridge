package bridge.domain;

public class Bridge {
    private final String direction;
    private StringBuilder bridge;

    public Bridge(MoveIndicator moveIndicator) {
        this.direction = moveIndicator.getIndicator();
        this.bridge = new StringBuilder();
    }

    public String buildSubBridge(String userDirection, String accessibleDirection) {
        if (!userDirection.equals(direction)) {
            bridge = BridgeElement.addElement(bridge);
            return getBridge();
        }
        bridge = BridgeElement.addElement(bridge, accessibleDirection.equals(direction));
        return getBridge();
    }

    public String getBridge() {
        return BridgeElement.build(bridge).toString();
    }
}
