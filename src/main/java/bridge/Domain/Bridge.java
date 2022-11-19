package bridge.Domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int lastPoint;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
        this.lastPoint = size - 1;
    }

    public boolean isValidDistance(int distance) {
        return lastPoint >= distance;
    }

    public boolean canCrossBridge(int distance, String position) {
        String validPosition = bridge.get(distance);
        return validPosition.equals(position);
    }

    public boolean isBridgeEnd(int distance) {
        return lastPoint == distance;
    }
}
