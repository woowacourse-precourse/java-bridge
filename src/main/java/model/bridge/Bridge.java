package model.bridge;

import java.util.List;

public class Bridge {

    private final List<PositionType> bridge;

    public Bridge(List<String> bridge) {
        List<PositionType> positionTypes = PositionType.getListByStringList(bridge);
        this.bridge = List.copyOf(positionTypes);
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
