package bridge;

public enum ValueCollection {
    VALUE_MIN(3),
    VALUE_MAX(20);

    private final int value;

    private ValueCollection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
