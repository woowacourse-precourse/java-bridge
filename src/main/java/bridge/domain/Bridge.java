package bridge.domain;

import java.util.List;

public class Bridge { // static -> non static

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getStepInBridge(int index) {
        return bridge.get(index);
    }

    public int size() {
        return bridge.size();
    }

    public boolean canPlayerCross(int inputPlayerIndex, String position) {
        return bridge.get(inputPlayerIndex).equals(position);
    }
}
