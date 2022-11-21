package bridge.domain.bridge;

public class BridgeIndex {
    private Integer index;

    public BridgeIndex(final Integer index) {
        this.index = index;
    }

    public static BridgeIndex generateZeroIndex() {
        return new BridgeIndex(0);
    }

    public Integer getAndIncrement() {
        this.incrementIndexPlusOne();
        return this.index;
    }

    private void incrementIndexPlusOne() {
        this.index += 1;
    }

    public boolean isLessThan(Integer size) {
        return index < size;
    }

}

