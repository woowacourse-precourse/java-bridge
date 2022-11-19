package bridge.domain;

import java.util.Arrays;

public enum Direction {
    DOWN(0, "D"),
    UP(1, "U");

    private int key;
    private String symbol;

    Direction(int key, String symbol) {
        this.key = key;
        this.symbol = symbol;
    }
    public String get() {
        return this.symbol;
    }
    public static Direction getByKey(int key) {
        return Arrays.stream(values())
                .filter(Direction -> Direction.key == key)
                .findFirst()
                .orElseThrow();
    }
}
