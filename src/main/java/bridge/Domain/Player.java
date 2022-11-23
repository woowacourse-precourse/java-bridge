package bridge.Domain;

public class Player {
    private final int startPoint = -1;
    private int distance;
    private Bridge bridge;

    public Player(Bridge bridge) {
        this.distance = startPoint;
        this.bridge = bridge;
    }

    public void movePlayer() {
        distance++;
    }

    public boolean isPlayerMoveSuccess(String position) {
        return bridge.isValidDistance(distance) && bridge.canCrossBridge(distance, position);
    }

    public boolean isPlayerInEndOfBridge() {
        return bridge.isBridgeEnd(distance);
    }

    public void initDistance() {
        this.distance = startPoint;
    }
}
