package bridge;

import java.util.List;
import java.util.function.Predicate;

import static bridge.Direction.*;
import static bridge.ErrorMessage.INCORRECT_BRIDGE_DIRECTION;

public class Bridge {
    private final List<String> path;

    public Bridge(List<String> path) {
        validateDirection(path);
        this.path = path;
    }

    private void validateDirection(List<String> path) {
        if (!path.stream().allMatch(Direction::isDirection)) {
            throw new IllegalArgumentException(INCORRECT_BRIDGE_DIRECTION);
        }
    }

    public boolean isPassable(int round, String move) {
        return path.get(round).equals(move);
    }
}
