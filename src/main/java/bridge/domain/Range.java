package bridge.domain;

import bridge.exception.InvalidRangeNumberException;

public enum Range {
    MAX(20),
    MIN(3);

    private final Integer range;

    Range(Integer range) {
        this.range = range;
    }

    public static void validate(Integer range) {
        if (Range.MIN.getRange() <= range
            && range <= Range.MAX.getRange()) {
            return;
        }

        throw new InvalidRangeNumberException();
    }

    private Integer getRange() {
        return range;
    }
}
