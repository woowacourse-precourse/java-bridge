package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMove(List<String> playerMoving, int index) {
        return bridge.get(index).equals(playerMoving.get(index));
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
