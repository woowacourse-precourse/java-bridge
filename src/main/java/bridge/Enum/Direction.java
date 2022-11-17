package bridge.Enum;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    DOWN(0, "D"),
    UP(1, "U"),
    ;

    private static final Map<Integer, Direction> numberToDirection = new HashMap<>();
    static {
        for (Direction dir : values()) {
            numberToDirection.put(dir.number,dir);
        }
    }

    private final int number;
    private final String initial;

    Direction(int number, String initial) {
        this.number = number;
        this.initial = initial;
    }

    public String getInitial() {
        return initial;
    }

    public static Direction getDirectionOfNumber(int number) {
        return numberToDirection.get(number);
    }
}
