package bridge.model;

public class BridgeSize {
    private int bridgeSize;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final int BRIDGE_SIZE_MIN = 3;

    public BridgeSize(int bridgeSize) {
        validBridgeSize(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    public void validBridgeSize(int bridgeSize) {
        if (bridgeSize > BRIDGE_SIZE_MAX || bridgeSize < BRIDGE_SIZE_MIN)
            throw new IllegalArgumentException();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}