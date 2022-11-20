package bridge.dto;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {
        this(parseBridgeSize(bridgeSize));
    }

    public BridgeSize(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    private static int parseBridgeSize(final String bridgeSize) {

        return Integer.parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
