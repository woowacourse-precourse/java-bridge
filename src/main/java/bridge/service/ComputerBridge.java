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

    public boolean checkInputBridge(List<String> checkBridge) {
        for (int index = 0; index < checkBridge.size(); index++) {
            if (!checkBridge.get(index).equals(bridge.get(index))) {
                return false;
            }
        }

        return true;
    }

    public boolean isEqual(List<String> checkBridge) {
        return bridge.equals(checkBridge);
    }

}
