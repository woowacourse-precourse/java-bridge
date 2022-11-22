package bridge;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    UP('U'),
    DOWN('D'),
    RETRY('R'),
    QUIT('Q');

    private final Character value;

    private static Map<Character, Command> mapping = new HashMap<>();

    static {
        mapping.put(UP.value, UP);
        mapping.put(DOWN.value, DOWN);
        mapping.put(RETRY.value, RETRY);
        mapping.put(QUIT.value, QUIT);
    }

    Command(Character value) {
        this.value = value;
    }

    public static Command getType(Character value) {
        return mapping.get(value);
    }

    public Character getValue() {
        return value;
    }
}
