package bridge.model;

import bridge.view.Sentence;

public class BridgeLength {

    private static final int MIN_LIMIT = 3;
    private static final int MAX_LIMIT = 20;

    private final Integer length;

    private BridgeLength(final int length) {
        if (!isBetweenRange(length)) {
            throw new IllegalArgumentException(Sentence.LENGTH_NOT_IN_RANGE.getValue());
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