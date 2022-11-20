package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    DOWNSIDE(0, "D"),
    UPSIDE(1, "U");

    private static Map<Integer, Direction> valueKeyStorage = new HashMap<>();
    private static Map<String, Direction> shortcutKeyStorage = new HashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            valueKeyStorage.put(direction.value, direction);
            shortcutKeyStorage.put(direction.shortcut, direction);
        }
    }

    public static Direction from(int value) {
        return valueKeyStorage.get(value);
    }

    public static Direction from(String shortcut) {
        return shortcutKeyStorage.get(shortcut);
    }

    public static boolean contains(String userInput) {
        return UPSIDE.shortcut.equals(userInput) || DOWNSIDE.shortcut.equals(userInput);
    }

    private final int value;
    private final String shortcut;

    Direction(int value, String shortcut) {
        this.value = value;
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return this.shortcut;
    }

    public int getValue() {
        return this.value;
    }
}
