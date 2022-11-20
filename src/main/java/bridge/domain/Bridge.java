package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isCanCross(int location, String goal) {
        return bridge.get(location).equals(goal);
    }

    public int size() {
        return bridge.size();
    }
}
