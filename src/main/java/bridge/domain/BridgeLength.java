package bridge.domain;

public enum BridgeLength {
    MIN(3) , MAX(20);
    public int bridgeLength;

    BridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

}
