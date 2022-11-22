package bridge.domain;

import bridge.exception.BridgeRangeException;

import java.util.List;

public class Bridge {

    private static final int BRIDGE_LOWER_NUMBER = 3;
    private static final int BRIDGE_UPPER_NUMBER = 20;
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    private void validate(List<String> bridge) {
        int size = bridge.size();
        if ((size < BRIDGE_LOWER_NUMBER) || (size > BRIDGE_UPPER_NUMBER)) {
            throw new BridgeRangeException(BRIDGE_LOWER_NUMBER, BRIDGE_UPPER_NUMBER);
        }
    }

    public String nowSpace(int now) {
        return bridge.get(now);
    }

    public int bridgeLength() {
        return bridge.size();
    }
}
