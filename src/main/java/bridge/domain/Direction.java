package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    DOWNSIDE(0, "D"),
    UPSIDE(1, "U");

    private static Map<Integer, Direction> storage = new HashMap<>();

    static {
        storage.put(DOWNSIDE.value, DOWNSIDE);
        storage.put(UPSIDE.value, UPSIDE);
    }

    public static Direction from(int value) {
        return storage.get(value);
    }

    private final int value;
    private final String shortCut;

    Direction(int value, String shortCut) {
        this.value = value;
        this.shortCut = shortCut;
    }

    public String shortcut() {
        return this.shortCut;
    }
}
