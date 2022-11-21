package bridge.model;

public enum Direction {
    U(1),
    D(0);

    private final int number;

    Direction(int number) {
        this.number = number;
    }

    public static String getDirectionByNumber(int number) {
        for (Direction direction : values()) {
            if (direction.number == number) {
                return direction.name();
            }
        }
        return null;
    }
}
