package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        System.out.println(bridge);
    }

    public boolean isSamePosition(int index, String userSelection) {
        return bridge.get(index).equals(userSelection);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean survivedToTheLast(int index) {
        return index == bridge.size() - 1;
    }

}
