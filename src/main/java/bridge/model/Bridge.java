package bridge.model;

import static bridge.model.Position.isSame;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        System.out.println(bridge);
    }

    public boolean isSamePosition(int index, Position position) {
        return isSame(bridge.get(index), position);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean survivedToTheLast(int index) {
        return index == bridge.size();
    }

}
