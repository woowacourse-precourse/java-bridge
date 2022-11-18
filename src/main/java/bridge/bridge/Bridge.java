package bridge.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final List<String> upper;
    private final List<String> lower;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.upper = new ArrayList<>();
        this.lower = new ArrayList<>();
    }

    public static Bridge generate(List<String> bridge) {
        return new Bridge(bridge);
    }

    public List<List<String>> makeMap() {
        return Arrays.asList(upper, lower);
    }

    public void move(String direction) {
        if (isMovable(direction)) {
            if (isUpper(direction)) {
                addMoving(Moving.MOVABLE, Moving.EMPTY);
            } else {
                addMoving(Moving.EMPTY, Moving.MOVABLE);
            }
        } else {
            if (isUpper(direction)) {
                addMoving(Moving.IMMOVABLE, Moving.EMPTY);
            } else {
                addMoving(Moving.EMPTY, Moving.IMMOVABLE);
            }
        }
    }

    private boolean isMovable(String direction) {
        return bridge.get(upper.size())
                .equals(direction);
    }

    private boolean isUpper(String direction) {
        return Direction.UP
                .equals(direction);
    }

    private void addMoving(Moving up, Moving down) {
        upper.add(up.moving());
        lower.add(down.moving());
    }

    public void refresh() {
        upper.clear();
        lower.clear();
    }

    public boolean isEnd() {
        return isAnyFail()
                || isAllSuccess();
    }

    public boolean isAnyFail() {
        return upper.contains(Moving.IMMOVABLE.moving())
                || lower.contains(Moving.IMMOVABLE.moving());
    }

    public boolean isAllSuccess() {
        return upper.size() == bridge.size()
                && !isAnyFail();
    }
}
