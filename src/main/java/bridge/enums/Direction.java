package bridge.enums;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    DOWN(0, "D"),
    UP(1, "U"),
    ;

    private static final Map<Integer, String> numberToInitial = new HashMap<>();
    static {
        for (Direction dir : values()) {
            numberToInitial.put(dir.number,dir.initial);
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

    public static String getDirectionInitialOfNumber(int number) {
        return numberToInitial.get(number);
    }
}
