package bridge.domain.bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    @Override
    public String toString() {
        return String.valueOf(bridge);
    }
}
