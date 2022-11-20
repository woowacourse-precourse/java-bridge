package enumCollections;

public enum Position {
    UP("U", 1),
    DOWN("D", 0);

    private final String status;
    private final int number;

    Position(String status, int number) {
        this.status = status;
        this.number = number;
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
        return position.number;
    }

    public static Position getPosition(String status) {
        for (Position position : Position.values()) {
            if (position.status == status) {
                return position;
            }
        }
        return null;
    }

    public static Position getOppositePosition(Position position) {
        if (position == Position.UP) {
            return Position.DOWN;
        }
        return Position.UP;
    }
}
