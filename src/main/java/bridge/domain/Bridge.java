package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge (BridgeLength length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(length.get());
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getLength() {
        return bridge.size();
    }
}
