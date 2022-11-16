package bridge.type;

public enum NumberType {

    BRIDGE_MIN_LENGTH(3),

    BRIDGE_MAX_LENGTH(20);

    private final int number;

    NumberType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
