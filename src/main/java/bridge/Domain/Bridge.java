package bridge.Domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isValidDistance(int distance) {
        return this.bridge.size() > distance;
    }

    public boolean canCrossBridge(int distance, String position) {
        return bridge.get(distance).equals(position); 
    }

    public boolean isBridgeEnd(int distance) {
        return this.bridge.size() == distance;
    }
}
