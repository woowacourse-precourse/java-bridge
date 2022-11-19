package bridge.domain;

import java.util.Objects;

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

    public static Move fromString(String direction) {
        if("U".equals(direction) || "1".equals(direction)) {
            return Move.UP;
        }
        if("D".equals(direction) || "0".equals(direction)) {
            return Move.DOWN;
        }
        throw new IllegalArgumentException();
    }
}
