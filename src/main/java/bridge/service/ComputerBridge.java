package bridge.service;

import java.util.ArrayList;
import java.util.List;

public class ComputerBridge {

    private List<String> bridge = new ArrayList<>();

    public String getBridgeInfo(int index) {
        return bridge.get(index);
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isEqual(List<String> checkBridge) {
        return bridge.equals(checkBridge);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
