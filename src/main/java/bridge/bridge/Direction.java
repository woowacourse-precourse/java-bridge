package bridge.bridge;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    UP(1, "U"),
    DOWN(0, "D"),
    ;

    private static final Map<Integer, String> BRIDGE_VALUE = new HashMap<>();
    static {
        for (Direction value : values()) {
            BRIDGE_VALUE.put(value.number, value.direction);
        }
    }

    private final int number;
    private final String direction;

    Direction(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public static String convert(int number) {
        return BRIDGE_VALUE.get(number);
    }
}
