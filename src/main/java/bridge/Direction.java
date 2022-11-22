package bridge;

import java.util.Arrays;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String shape;

    private final int number;

    Direction(final String shape, final int number) {
        this.shape = shape;
        this.number = number;
    }

    public static String getShape(final int number) {
        return Arrays.stream(values())
            .filter(direction -> direction.matchNumber(number))
            .map(Direction::getShape)
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    public static Direction of(final String shape) {
        return Arrays.stream(values())
            .filter(direction -> direction.matchShape(shape))
            .findAny()
            .orElseThrow(IllegalArgumentException::new);
    }

    public boolean matchShape(final String shape) {
        return this.shape.equals(shape);
    }

    private boolean matchNumber(final int number) {
        return this.number == number;
    }

    private String getShape() {
        return shape;
    }
}