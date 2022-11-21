package bridge.model;

public enum Direction {
    DOWN(0),
    UP(1);

    private final int number;

    Direction(int number) {
        this.number = number;
    }

    public static boolean isEqual(int number, Direction direction) {
        return number == direction.number;
    }
}
