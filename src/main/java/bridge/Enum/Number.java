package bridge.Enum;

public enum Number {
    MIN(3),
    MAX(20),
    ;

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
