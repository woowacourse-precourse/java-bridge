package bridge.range;

public class Range {

    private final int fromInclusive;
    private final int toInclusive;

    private Range(
            final int fromInclusive,
            final int toInclusive
    ) {
        this.fromInclusive = fromInclusive;
        this.toInclusive = toInclusive;
    }

    public static Range between(
            int fromInclusive,
            int toInclusive
    ) {
        if (fromInclusive > toInclusive) {
            final int tmp = fromInclusive;
            fromInclusive = toInclusive;
            toInclusive = tmp;
        }
        return new Range(fromInclusive, toInclusive);
    }

    public boolean contains(final int value) {
        return (fromInclusive <= value) && (value <= toInclusive);
    }
}
