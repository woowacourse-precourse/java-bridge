package bridge.domain;

public class BridgeIndex {
    private int index;

    public BridgeIndex() {
        this.index = 0;
    }

    public void increase() {
        index++;
    }

    public void reset() {
        index = 0;
    }

    public boolean isGreaterThan(int bridgeSize) {
        return index >= bridgeSize;
    }

    public int getIndex() {
        return index;
    }
}
