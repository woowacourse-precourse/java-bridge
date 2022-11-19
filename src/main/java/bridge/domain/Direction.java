package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP(0, "U"),
    DOWN(1, "D");

    private int key;
    private String symbol;

    Direction(int key, String symbol) {
        this.key = key;
        this.symbol = symbol;
    }
    public String getSymbol() {
        return this.symbol;
    }

    public int getKey() {
        return this.key;
    }

    public static Direction getByKey(int key) {
        return Arrays.stream(values())
                .filter(Direction -> Direction.key == key)
                .findFirst()
                .orElseThrow();
    }

    public static Direction getBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(Direction -> symbol.equals(Direction.symbol))
                .findFirst()
                .orElseThrow();
    }

}
