package bridge.Enum;

public enum BridgeInfo {
    MIN_SIZE(3),
    MAX_SIZE(20);

    private final int info;

    BridgeInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
