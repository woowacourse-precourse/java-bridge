package bridge.model;

public enum CrossBridgeType {
    UPPER_BRIDGE("U", 1),
    DOWN_BRIDGE("D", 0);
    private final String StringKey;
    private final int binaryKey;

    private CrossBridgeType(String StringKey, int binaryKey) {
        this.StringKey = StringKey;
        this.binaryKey = binaryKey;
    }

    public String getStringKey() {
        return StringKey;
    }

    public int getBinaryKey() {
        return binaryKey;
    }
}
