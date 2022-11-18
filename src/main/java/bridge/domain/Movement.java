package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private List<String> movement = new ArrayList<>();
    private int tryCount;

    public Movement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(String moving) {
        saveMoving(moving);
        int nowIndex = movement.size() - 1;
        if (!moving.equals(bridge.get(nowIndex))) {
            return false;
        }
        return true;
    }

    private void saveMoving(String moving) {
        this.movement.add(moving);
    }

    public boolean isFinish() {
        if (bridge.size() == movement.size()) {
            return true;
        }
        return false;
    }

    public void clearMoving() {
        this.movement = new ArrayList<>();
        tryCount++;
    }
}