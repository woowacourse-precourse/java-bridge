package bridge.Util;

public enum BRIDGE_CONSTANTS {
    MAX_BRIDGE_COUNT(20),
    MIN_BRIDGE_COUNT(3);

    private int count;

    BRIDGE_CONSTANTS(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
