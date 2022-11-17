package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(List<String> userMoved) {
        int userMovedSize = userMoved.size();
        return bridge.get(userMovedSize - 1) == userMoved.get(userMovedSize - 1);
    }
}
