package bridge.util;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    private final String bridgePosition;
    private final int bridgeNumber;

    BridgePosition(String bridgePosition, int bridgeNumber) {
        this.bridgePosition = bridgePosition;
        this.bridgeNumber = bridgeNumber;
    }

    public boolean isEqualToBridgeNumber(int bridgeNumber) {
        return this.bridgeNumber == bridgeNumber;
    }

    public boolean isEqualToBridgePosition(String bridgePosition) {
        return this.bridgePosition.equals(bridgePosition);
    }

    public String getBridgePosition() {
        return bridgePosition;
    }
}
