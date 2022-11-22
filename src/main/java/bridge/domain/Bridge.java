package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(List<String> userMoved, int idx) {
        return bridge.get(idx).equals(userMoved.get(idx));
    }

    public boolean isSizeEqualTo(List<String> anyList) {
        return bridge.size() == anyList.size();
    }
}
