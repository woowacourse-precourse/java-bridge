package bridge.domain;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);
    private String direction;
    private int number;

    Move(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static Move from(String direction) {
        if ("U".equals(direction) || "1".equals(direction)) {
            return Move.UP;
        }
        if ("D".equals(direction) || "0".equals(direction)) {
            return Move.DOWN;
        }
        throw new IllegalArgumentException("올바르지 않은 방향이 입력되었습니다. (입력:" + direction + ")");
    }

    public static Move from(int number) {
        if (number == 0) {
            return Move.DOWN;
        }
        if (number == 1) {
            return Move.UP;
        }
        throw new IllegalArgumentException("올바르지 않은 방향이 입력되었습니다. (입력:" + number + ")");
    }

    public String getDirection() {
        return direction;
    }
}
