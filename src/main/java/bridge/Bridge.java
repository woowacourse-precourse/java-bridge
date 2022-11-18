package bridge;

public enum Bridge {
    UPPER_DIRECTION("U", 1),
    LOWER_DIRECTION("D", 0);

    private final String direction;
    private final int value;

    Bridge(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public int getValue() {
        return value;
    }
}
