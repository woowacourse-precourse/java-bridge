package bridge.paths;

import bridge.identifiers.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerPath {

    private final List<Direction> currentPath = new ArrayList<>();
    private boolean isAlive = true;

    public PlayerPath() {
    }

    public void saveDirection(Direction direction) {
        currentPath.add(direction);
    }

    public List<Direction> getPath() {
        return Collections.unmodifiableList(currentPath);
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }
}
