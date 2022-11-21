package bridge.service;

import java.util.ArrayList;
import java.util.List;

public class ComputerBridge {

    private List<String> bridge = new ArrayList<>();

    public int getBridgeLength() {
        return this.bridge.size();
    }

    public String getBridgeLast() {
        return bridge.get(bridge.size() - 1);
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

}
