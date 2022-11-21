package bridge.value;

public enum LocationValue {
    LOCATION_INIT(0),
    LOCATION_INCREMENT(1);
    private final int value;

    LocationValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
