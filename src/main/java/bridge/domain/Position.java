package bridge.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Position {  // 0 ~ 19까지 제한되어 있어, 캐싱 해도 됨.

    private static final Map<Integer, Position> POSITIONS = new HashMap<>();

    static {
        IntStream.rangeClosed(0, 19)
                .forEach(i -> POSITIONS.put(i, new Position(i)));
    }

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position of(int key) {
        return POSITIONS.get(key);
    }

    Position increase() {
        return POSITIONS.get(value + 1);
    }

    Position reset() {
        return POSITIONS.get(0);
    }

    boolean isLessThan(int size) {
        return value < size;
    }

    int value() {
        return value;
    }
}
