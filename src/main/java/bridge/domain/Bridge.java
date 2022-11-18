package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isFinish(List<String> movement) {
        if (this.bridge.size() == movement.size()) {
            return true;
        }
        return false;
    }

    public boolean canMove(int nowIndex, String status) {
        if (!status.equals(bridge.get(nowIndex))) {
            return false;
        }
        return true;
    }
}
