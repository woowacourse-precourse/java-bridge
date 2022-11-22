package bridge.service;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {

    private List<String> bridge = new ArrayList<>();

    public void addBridge(String location) {
        this.bridge.add(location);
    }

    public int getBridgeLength() {
        return this.bridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeLast() {
        return bridge.get(bridge.size() - 1);
    }
}
