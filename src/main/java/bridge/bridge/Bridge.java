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

    public void move(String moving) {
        addMoving(
                selectMoving(Moving.UP, moving),
                selectMoving(Moving.DOWN, moving)
        );
    }

    private Step selectMoving(Moving direction, String moving) {
        if (direction.equals(moving)) {
            if (isMovable(moving)) {
                return Step.MOVABLE;
            }
            return Step.IMMOVABLE;
        }
        return Step.EMPTY;
    }

    private boolean isMovable(String moving) {
        return bridge
                .get(upper.size())
                .equals(moving);
    }

    private void addMoving(Step up, Step down) {
        upper.add(up.value());
        lower.add(down.value());
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
        return upper.contains(Step.IMMOVABLE.value())
                || lower.contains(Step.IMMOVABLE.value());
    }

    public boolean isAllSuccess() {
        return upper.size() == bridge.size()
                && !isAnyFail();
    }
}
