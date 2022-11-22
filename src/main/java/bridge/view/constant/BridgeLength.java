package bridge.view.constant;

public enum BridgeLength {

    MIN_BRIDGE_LENGTH(3), MAX_BRIDGE_LENGTH(20);

    private final int length;

    BridgeLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
}
