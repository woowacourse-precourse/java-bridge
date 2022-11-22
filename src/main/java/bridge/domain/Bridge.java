package bridge.domain;

import static bridge.util.InputValidator.validateBridgeSize;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateBridgeSize(bridge.size());
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
