package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(BridgeCell cell, int position) {
        return BridgeCell.getBridgeCell(bridge.get(position)) == cell;
    }

}
