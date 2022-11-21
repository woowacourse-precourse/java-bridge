package bridge.constant;

public enum NumberType {
    INITIALIZE_TO_ZERO(0),
    INITIALIZE_TO_ONE(1),
    ONE(1),
    ;

    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
