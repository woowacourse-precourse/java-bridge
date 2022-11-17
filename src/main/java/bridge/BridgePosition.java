package bridge;

public enum BridgePosition {
    UP("U", 1),
    DOWN("D", 0);

    private final String bridgePosition;
    private final int bridgeNumber;

    BridgePosition(String bridgePosition, int bridgeNumber) {
        this.bridgePosition = bridgePosition;
        this.bridgeNumber = bridgeNumber;
    }

    public boolean isEqual(int bridgeNumber) {
        return this.bridgeNumber == bridgeNumber;
    }

    public String getBridgePosition() {
        return bridgePosition;
    }
}
