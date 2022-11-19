package bridge.constant;

public enum BridgeSizeRule {
    MINIMUM_SIZE(3),
    MAXIMUM_SIZE(20);

    public final Integer size;

    BridgeSizeRule(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
