package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public String getBridgeIdx(int index) {
        return bridge.get(index);
    }
}
