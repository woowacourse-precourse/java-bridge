package bridge.domain;

public class BridgeIndex {

    private int index;

    private BridgeIndex(int index) {
        this.index = index;
    }

    public static BridgeIndex initIndex() {
        return new BridgeIndex(-1);
    }

    public void increment() {
        this.index += 1;
    }

    public int getIndex() {
        return index;
    }
}
