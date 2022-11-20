package bridge.domain;

import bridge.constance.GameConstance;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public void init(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCross(int position, String moving) {
        String block = bridge.get(position);
        return block.equals(moving);
    }

    public boolean isUpBlock(int position) {
        String block = bridge.get(position);
        return block.equals(GameConstance.UP_BLOCK_EXPRESSION);
    }

    public boolean isDoneCrossingBridge(int position) {
        return position == bridge.size();
    }
}
