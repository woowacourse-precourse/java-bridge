package bridge.value;

public enum UtilValue {

    EMPTY_SIZE(0);
    private final int value;

    UtilValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
