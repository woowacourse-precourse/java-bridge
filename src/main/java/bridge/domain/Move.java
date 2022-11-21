package bridge.domain;

public enum Move {
    UP("U", 1),
    DOWN("D", 0)
    ;
    private String direction;
    private int number;

    Move(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static Move from(String direction) {
        if("U".equals(direction) || "1".equals(direction)) {
            return Move.UP;
        }
        if("D".equals(direction) || "0".equals(direction)) {
            return Move.DOWN;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public static Move from(int number) {
        if (number == 0) {
            return Move.DOWN;
        }
        if (number == 1) {
            return Move.UP;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public String getDirection() {
        return direction;
    }
}
