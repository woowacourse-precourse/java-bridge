package bridge.domain;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private List<String> bridge;

    public Bridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    // TODO: get 고려
    public String get(int index) {
        return this.bridge.get(index);
    }
}
