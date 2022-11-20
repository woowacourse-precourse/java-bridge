package bridge.Enum;

/* 다리의 방향(UP/DOWN)을 나타내는 상수입니다 */

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private int number;
    private String string;

    private Direction(int number, String string) {
        this.number = number;
        this.string = string;
    }

    public static String toString(int number) {
        if (Direction.UP.number == number) {
            return Direction.UP.string;
        }
        return Direction.DOWN.string;
    }

    public String getString() {
        return string;
    }
}
