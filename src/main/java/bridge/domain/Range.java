package bridge.domain;

public enum Range {
    MAX(20),
    MIN(3);

    private final Integer range;

    Range(Integer range) {
        this.range = range;
    }
}
