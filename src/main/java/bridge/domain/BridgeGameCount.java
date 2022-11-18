package bridge.domain;

public class BridgeGameCount {
    private int count;

    public BridgeGameCount() {
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
