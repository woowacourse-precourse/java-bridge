package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }
}
