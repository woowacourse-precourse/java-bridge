package bridge.Domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int lastPoint;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.lastPoint = bridge.size() - 1;
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
