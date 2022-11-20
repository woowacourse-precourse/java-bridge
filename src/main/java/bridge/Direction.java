package bridge;

public enum Direction {
    DOWN("D", 0),
    UP("U", 1);

    private final String shape;
    private final int value;

    Direction(String shape, int value) {
        this.shape = shape;
        this.value = value;
    }

    public String getShape() {
        return shape;
    }

    public int getValue() {
        return value;
    }
}
