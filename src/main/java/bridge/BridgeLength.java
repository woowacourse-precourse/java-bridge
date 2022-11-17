package bridge;

public enum BridgeLength {
    MIN(3) , MAX(20);
    private int bridgeLength;

    BridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }
}
