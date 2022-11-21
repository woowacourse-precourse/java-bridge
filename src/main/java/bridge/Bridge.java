package bridge;

public enum Bridge {
    LOWER_BRIDGE("D", 0),
    UPPER_BRIDGE("U", 1),
    ;

    private final String direction;
    private final int number;

    Bridge(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public String getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }
}