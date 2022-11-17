package bridge.Enum;

public enum BridgeSizeInfo {
    MIN_SIZE(3),
    MAX_SIZE(20);

    private int info;

    BridgeSizeInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
