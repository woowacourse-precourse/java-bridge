package bridge.domain;

import bridge.domain.Direction;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<Direction> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = initializeBridge(bridge);
    }

    public List<Direction> initializeBridge(List<String> lst) {
        List<Direction> bridge = new ArrayList<>();
        for (String direction : lst) {
            bridge.add(Direction.toDirection(direction));
        }
        return bridge;
    }

    public boolean canMoveTo(Direction userDirection, int idx) {
        return bridge.get(idx).equals(userDirection);
    }

    public boolean isAllCrossed(int pointer) {
        return bridge.size() == pointer;
    }

}