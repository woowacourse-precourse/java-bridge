package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int bridgeLength) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> makeBridge = bridgeMaker.makeBridge(bridgeLength);
        this.bridge = makeBridge;
    }

    public boolean possibleNextStep() {
        return false;
    }
}
