package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isFinish(Movement movement) {
        if (this.bridge.size() == movement.getMoveCount()) {
            return true;
        }
        return false;
    }

    public boolean canMove(Movement movement) {
        int nowIndex = movement.getMoveCount()-1;
        if (!movement.getMoving().equals(bridge.get(nowIndex))) {
            return false;
        }
        return true;
    }
}
