package bridge.model;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }
}
