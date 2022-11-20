package bridge;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(final int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean hasUAtIndex(int index) {
        if (bridge.get(index).equals("U")) {
            return true;
        }
        return false;
    }
}
