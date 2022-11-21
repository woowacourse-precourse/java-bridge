package enumCollections;

public enum Position {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private final String status;
    private final int number;
    private final int index;

    Position(String status, int number, int index) {
        this.status = status;
        this.number = number;
        this.index = index;
    }

    public static String getStatus(Position position) {
        return position.status;
    }

    public static String getStatus(int number) {
        if (UP.number == number) {
            return UP.status;
        }
        return DOWN.status;
    }

    public static int getIndex(Position position) {
        return position.index;
    }

    public static Position getPosition(String status) {
        if (Position.UP.status == status) {
            return Position.UP;
        }
        return Position.DOWN;
    }

    public static Position getOppositePosition(Position position) {
        if (position == Position.UP) {
            return Position.DOWN;
        }
        return Position.UP;
    }
}
