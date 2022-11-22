package bridge;

import java.util.List;

public class Bridge {
    public final List<String> bridge;

    public Bridge(List<String> bridge) {
        bridgeValidation(bridge);
        this.bridge = bridge;
    }

    private void bridgeValidation(List<String> bridge) {
        if (bridge.size() < 3 || 20 < bridge.size()) {
            throw new IllegalStateException("다리의 크기가 3과 20사이가 아닙니다.");
        }
    }

    public List<String> getBridge() {
        return bridge;
    }
}
