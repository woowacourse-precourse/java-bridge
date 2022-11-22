package bridge.utils.status;

public enum BridgeStatus {

    MIN_BRIDGE_SIZE(3),
    MAX_BRIDGE_SIZE(20);

    private final int size;

    BridgeStatus(int size) {
        this.size = size;
    }

    public static boolean isOutOfRange(int size) {
        return (size < MIN_BRIDGE_SIZE.size) || (size > MAX_BRIDGE_SIZE.size);
    }
    
}
