package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public List<String> bridges;

    public Bridge() {
        bridges = new ArrayList<>();
    }

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public List<String> getBridges() {
        return bridges;
    }

    public void addNewBridge(String bridge) {
        bridges.add(bridge);
    }

    public int getSize() {
        return bridges.size();
    }

    public String getBridgeByIndex(int index) {
        return bridges.get(index);
    }
}
