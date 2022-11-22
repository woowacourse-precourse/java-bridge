package bridge.value;

public enum RecordValue {

    RECORD_INIT(1),
    RECORD_INCREMENT(1);
    private final int value;

    RecordValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
