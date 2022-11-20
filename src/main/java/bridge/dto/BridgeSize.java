package bridge.dto;

public class BridgeSize {
    int bridgeSize;

    public BridgeSize(String bridgeSize) {
        this(parseBridgeSize(bridgeSize));
    }

    public BridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    private static int parseBridgeSize(String bridgeSize) {

        return Integer.parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
