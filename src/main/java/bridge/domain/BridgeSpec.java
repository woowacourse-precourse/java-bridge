package bridge.domain;

public enum BridgeSpec {

    MIN(3),
    MAX(20);

    private int size;

    BridgeSpec(int size) {
        this.size = size;
    }

    public int size() {
        return this.size;
    }
}
