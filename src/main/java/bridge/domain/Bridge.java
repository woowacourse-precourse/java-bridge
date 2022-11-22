package bridge.domain;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("Bridge.Bridge(): " + this.bridge); // DEBUG
    }

    public boolean isCorrectDirection(int index, String direction) {
        return this.bridge.get(index).equals(direction);
    }
}
