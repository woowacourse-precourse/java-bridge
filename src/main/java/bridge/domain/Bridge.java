package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {
    private static final BridgeMaker BRIDGE_MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge generateBridge(int bridgeSize) {
        return new Bridge(BRIDGE_MAKER.makeBridge(bridgeSize));
    }

    public boolean isMovable(String move, int location) {
        return bridge.get(location).equals(move);
    }

    public int size() {
        return bridge.size();
    }
}
