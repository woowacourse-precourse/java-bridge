package bridge.domain;

public enum BridgeInfo {
    BRIDGE_BOTTOM (0, "D"),
    BRIDGE_TOP (1, "U");

    private final int bridgeNumber;
    private final String hardBridgePosition;
    BridgeInfo(int bridgeNumber, String hardBridgePosition) {
        this.bridgeNumber = bridgeNumber;
        this.hardBridgePosition = hardBridgePosition;
    }

    public int getBridgeNumber() {
        return bridgeNumber;
    }

    public String getHardBridgePosition() {
        return hardBridgePosition;
    }
}
