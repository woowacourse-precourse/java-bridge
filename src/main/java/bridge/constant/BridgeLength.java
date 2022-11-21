package bridge.constant;

public enum BridgeLength {

    MIN_BRIDGE_LENGTH(3), MAX_BRIDGE_LENGTH(20);

    private final int bridgeLength;

    BridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    public int getValue() {
        return this.bridgeLength;
    }
}
