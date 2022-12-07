package bridge.domain;

public class BridgeGameCount {
    private int count;

    public BridgeGameCount(int count) {
        this.count = count;
    }

    public static BridgeGameCount initBridgeGameCount() {
        return new BridgeGameCount(1);
    }

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
