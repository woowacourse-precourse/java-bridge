package bridge.enums;

public enum Number {
    RANGE_MIN(3),
    RANGE_MAX(20),
    D_NUMBER(0),
    U_NUMBER(1),
    NUMBER_OF_ATTEMPTS(0);


    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
