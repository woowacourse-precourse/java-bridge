package bridge;

public enum IntegerValue {

    MIN_VALUE(3),
    MAX_VALUE(20);
    private final int integerValue;
    IntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }
}
