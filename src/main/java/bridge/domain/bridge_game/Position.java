package bridge.domain.bridge_game;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Position {

    private static final Map<Integer, Position> POSITIONS = new HashMap<>();

    static {
        IntStream.rangeClosed(0, 19)
                .forEach(i -> POSITIONS.put(i, new Position(i)));
    }

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position of(final int key) {
        validateKeyOfPosition(key);
        return POSITIONS.get(key);
    }

    Position increase() {
        validateKeyOfPosition(value + 1);
        return POSITIONS.get(value + 1);
    }

    Position reset() {
        return POSITIONS.get(0);
    }

    boolean isLessThan(final int size) {
        return value < size;
    }

    int value() {
        return value;
    }

    private static void validateKeyOfPosition(final int key) {
        if (!POSITIONS.containsKey(key)) {
            throw new IllegalArgumentException("Player의 위치 값은 0~19까지만 가능합니다.");
        }
    }
}
