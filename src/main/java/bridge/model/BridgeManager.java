package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

public class BridgeManager {
    private final BridgeMaker bridgeMaker;

    public BridgeManager(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void setBridgeWithSize(int size) {

    }

    public void isMovable(String location) {

    }
}
