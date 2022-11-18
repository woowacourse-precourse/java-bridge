package bridge.bridge;

import java.util.HashMap;
import java.util.Map;

public enum Moving {

    UP(1, "U"),
    DOWN(0, "D"),
    ;

    private static final Map<Integer, String> MOVING_DIRECTION = new HashMap<>();
    static {
        for (Moving value : values()) {
            MOVING_DIRECTION.put(value.number, value.direction);
        }
    }

    private final int number;
    private final String direction;

    Moving(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public boolean equals(String moving) {
        return moving.equals(this.direction);
    }

    public static String convert(int number) {
        return MOVING_DIRECTION.get(number);
    }
}
