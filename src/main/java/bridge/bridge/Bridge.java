package bridge.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridge {
    private static final String MOVABLE = "O";
    private static final String IMMOVABLE = "X";
    private static final String EMPTY = " ";

    private final List<String> bridge;
    private final List<String> up;
    private final List<String> down;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    public static Bridge generate(List<String> bridge) {
        return new Bridge(bridge);
    }

    public List<List<String>> makeMap() {
        return Arrays.asList(up, down);
    }

    public void move(String direction) {
        int index = up.size();

        if (bridge.get(index).equals(direction)) {
            if (direction.equals("U")) {
                up.add(MOVABLE);
                down.add(EMPTY);
            } else if (direction.equals("D")) {
                up.add(EMPTY);
                down.add(MOVABLE);
            }
        } else {
            if (direction.equals("U")) {
                up.add(IMMOVABLE);
                down.add(EMPTY);
            } else if (direction.equals("D")) {
                up.add(EMPTY);
                down.add(IMMOVABLE);
            }
        }
    }

    public void refresh() {
        up.clear();
        down.clear();
    }

    public boolean isEnd() {
        return isAnyFail()
                || isAllSuccess();
    }

    public boolean isAnyFail() {
        return up.contains(IMMOVABLE)
                || down.contains(IMMOVABLE);
    }

    public boolean isAllSuccess() {
        return up.size() == bridge.size()
                && !isAnyFail();
    }
}
