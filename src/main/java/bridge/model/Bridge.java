package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public void addBridge(String stage) {
        this.bridge.add(stage);
    }
}
