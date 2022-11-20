package bridge.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Direction {
    UP("U", (directionValue) -> directionValue == 1),
    DOWN("D", (directionValue) -> directionValue == 0);

    private final String directionInitial;
    private final Predicate<Integer> isMatch;

    Direction(String directionInitial, Predicate<Integer> isMatch) {
        this.directionInitial = directionInitial;
        this.isMatch = isMatch;
    }

    public String getDirectionInitial() {
        return directionInitial;
    }
}
