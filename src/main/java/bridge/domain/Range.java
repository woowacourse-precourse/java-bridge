package bridge.domain;

import bridge.exception.InvalidRangeNumberException;

public enum Range {
    MAX(20),
    MIN(3);

    private final Integer range;

    Range(Integer range) {
        validate(range);
        this.range = range;
    }

    private void validate(Integer range) {
        if (Range.MIN.getRange() <= range
            && range <= Range.MAX.getRange()) {
            return;
        }

        throw new InvalidRangeNumberException();
    }

    public Integer getRange() {
        return range;
    }
}
