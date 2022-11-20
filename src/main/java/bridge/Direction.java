package bridge;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String floor;
    private final int value;

    Direction(String shape, int value) {
        this.floor = shape;
        this.value = value;
    }

    public static Direction of(int generate) {
        if(generate == 1) {
            return UP;
        }
        return DOWN;
    }

    public String getFloor() {
        return floor;
    }

    public int getValue() {
        return value;
    }
}
