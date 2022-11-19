package bridge.Domain;

public class Player {
    private final int startPoint = -1;
    private int distance;

    public Player() {
        this.distance = startPoint;
    }

    public void movePlayer() {
        distance++;

    }

    public int getPosition() {
        return this.distance;
    }

    public boolean isPlayerInEndOfBridge(Bridge bridge) {
        return bridge.isBridgeEnd(distance);
    }

    public void initPosition() {
        this.distance = startPoint;
    }
}
