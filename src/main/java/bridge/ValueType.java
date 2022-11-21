package bridge;

public enum ValueType {

    BRIDGE_SIZE_START(3),
    BRIDGE_SIZE_END(20);

    private final int value;

    ValueType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
