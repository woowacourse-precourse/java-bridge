package bridge.model;

public class BridgeLength {

    private Integer length;
    private static final int MIN_LIMIT = 3;
    private static final int MAX_LIMIT = 20;

    private BridgeLength(final int length) {
        if (!isBetweenRange(length)) {
            throw new IllegalArgumentException("input not in range");
        }
        this.length = length;
    }

    public static BridgeLength from(final int length) {
        return new BridgeLength(length);
    }

    private boolean isBetweenRange(final int length) {
        return length >= MIN_LIMIT && length <= MAX_LIMIT;
    }

    public int getLength() {
        return length;
    }
}
