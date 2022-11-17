package bridge.model;

public enum BridgeSizeRule {
    START(3),
    END(20),
    ;

    private final int size;

    BridgeSizeRule(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
