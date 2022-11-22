package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(BridgeNumberGenerator bridgeNumberGenerator, int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    public boolean canGo(int index, String ud) {
        return bridge.get(index).equals(ud);
    }

    public int size() {
        return bridge.size();
    }
}
