package bridge.value;

public enum RecordValue {
    INIT(1),
    INCREMENT(1);
    private final int value;

    RecordValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
