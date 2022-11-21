package bridge.domain;

import bridge.exception.InvalidDirectionFormatException;

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

    public void validate(String directionInitial) {
        if (directionInitial.equals(Direction.UP.getDirectionInitial())
            || directionInitial.equals(Direction.DOWN.getDirectionInitial())) {
            return;
        }

        throw new InvalidDirectionFormatException();
    }

    public String getDirectionInitial() {
        return directionInitial;
    }

    public static Direction getDirection(int generate) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.isMatch.test(generate))
                .findAny()
                .orElseThrow(InvalidDirectionFormatException::new);
    }
}
