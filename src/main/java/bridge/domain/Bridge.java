package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(BridgeCell cell, int position) {
        validatePosition(position);
        return BridgeCell.getBridgeCell(bridge.get(position)) == cell;
    }

    private void validatePosition(int position) {
        if (position >= bridge.size() || position < 0) {
            throw new IndexOutOfBoundsException("[ERROR] 해당 위치는 존재하지 않습니다.");
        }
    }

    public int size() {
        return bridge.size();
    }
}
