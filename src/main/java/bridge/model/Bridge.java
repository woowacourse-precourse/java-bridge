package bridge.model;

import java.util.List;

import static bridge.message.ErrorMessage.INCORRECT_BRIDGE_DIRECTION;

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

    public int getSize() {
        return path.size();
    }
}
