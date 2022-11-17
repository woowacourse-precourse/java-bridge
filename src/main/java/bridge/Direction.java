package bridge;

public enum Direction {

    DOWN(0, "D"),
    UP(1, "U")
    ;

    private final int number;
    private final String position;

    Direction(int number, String position) {
        this.number = number;
        this.position = position;
    }

    public static String getPosition(int upDown) {
        if (upDown == DOWN.number) {
            return DOWN.position;
        }
        return UP.position;
    }

}
