package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public String getBlock(int index) {
        return bridge.get(index);
    }

    public void setBridge(List<String> bridge) {
        this.bridge.addAll(bridge);
    }
}
