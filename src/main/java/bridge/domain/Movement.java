package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private List<Moving> movement = new ArrayList<>();
    private int tryCount;

    public Movement(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(Moving moving) {
        saveMoving(moving);
        int nowIndex = movement.size()-1;
        if (!moving.isSame(bridge.get(nowIndex))){
            return false;
        }
        return true;
    }

    public void saveMoving(Moving moving) {
        this.movement.add(moving);
    }

    public boolean isFinish() {
        if (bridge.size() == movement.size()) {
            return true;
        }
        return false;
    }

}