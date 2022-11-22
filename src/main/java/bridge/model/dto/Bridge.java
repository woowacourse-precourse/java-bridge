package bridge.model.dto;

import java.util.List;

public class Bridge {
    private final List<String> BRIDGE;

    public Bridge(List<String> bridge) {
        this.BRIDGE = bridge;
    }

    public List<String> getBridge() {
        return BRIDGE;
    }
}
