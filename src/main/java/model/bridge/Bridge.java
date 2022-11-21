package model.bridge;

import java.util.List;

public class Bridge {
    private final List<BridgeType> bridge;

    public Bridge(List<String> bridge) {
        List<BridgeType> bridgeTypes = BridgeType.getListByStringList(bridge);
        this.bridge = List.copyOf(bridgeTypes);
    }

    public boolean canMove(int stage, MoveMark mark) {
        return mark.canMove(bridge.get(stage));
    }

    public boolean isLast(int stage) {
        return bridge.size() == stage;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
