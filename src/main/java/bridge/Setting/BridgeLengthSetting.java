package bridge.Setting;

public enum BridgeLengthSetting {
    MIN_LENGTH(3),
    MAX_LENGTH(20);

    private final int length;

    BridgeLengthSetting(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
