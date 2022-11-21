package bridge.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Moving {
    UP("U"),
    DOWN("D"),
    ;

    private final String direction;
    private final static Map<String, Moving> movingMap = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> movingMap.put(e.direction, e));
    }

    Moving(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public static boolean contains(final String direction) {
        return Arrays.stream(values())
                .map(Moving::getDirection)
                .collect(Collectors.toList())
                .contains(direction);
    }

    public static Moving getMoveDirection(final String direction) {
        return movingMap.get(direction);
    }
}
