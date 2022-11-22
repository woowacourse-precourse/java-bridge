package bridge.constant;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    DOWNSIDE(0, "D"),
    UPSIDE(1, "U");

    public static final String INVALID_BRIDGE_MOVE_INPUT_MSG = "유효하지 않은 다리 이동 명령입니다. (위: U, 아래: D)";

    private static Map<String, Direction> shortcutKeyStorage = new HashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            shortcutKeyStorage.put(direction.shortcut, direction);
        }
    }

    public static Direction from(String shortcut) {
        return shortcutKeyStorage.get(shortcut);
    }

    public static boolean contains(String userInput) {
        return UPSIDE.shortcut.equals(userInput) || DOWNSIDE.shortcut.equals(userInput);
    }

    public static String toShortcut(int order) {
        if (order == DOWNSIDE.order) {
            return DOWNSIDE.shortcut;
        }
        return UPSIDE.shortcut;
    }

    private final int order;
    private final String shortcut;

    Direction(int order, String shortcut) {
        this.order = order;
        this.shortcut = shortcut;
    }
}
