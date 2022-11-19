package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public void init(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeByPositionToMove(int position) {
        return this.bridge.get(position);
    }
}
